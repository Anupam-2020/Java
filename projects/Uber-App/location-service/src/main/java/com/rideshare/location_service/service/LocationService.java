package com.rideshare.location_service.service;

import com.rideshare.location_service.dto.DriverLocationRequest;
import com.rideshare.location_service.dto.NearByDriverResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.*;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationService {

    // redis key for all driver locations.
    private static final String DRIVERS_GEO_KEY = "drivers:locations";

    private final RedisTemplate<String, String> redisTemplate;

     /*update driver location in redis.
       Called in every 3 seconds by driver's phone.
       Maps to redis GEOADD command
     */
    public void updateDriverLocation(DriverLocationRequest driverLocationRequest) {
        log.info("Updating location for driver: {}", driverLocationRequest.getDriverId());

        // IMPORTANT: longitude FIRST, latitude SECOND - GeoSpatial Standard.
        Point driverPoint = new Point(
                driverLocationRequest.getLongitude(),
                driverLocationRequest.getLatitude()
        );

        redisTemplate.opsForGeo().add(
                DRIVERS_GEO_KEY,
                driverPoint,
                driverLocationRequest.getDriverId()
        );

        log.info("Location updated for driver: {}", driverLocationRequest.getDriverId());
    }

    /*
    * Find nearby drivers within given radius.
    * Called by matching Service on ride request.
    * Maps to Redis GEORADIUS command
    */
    public List<NearByDriverResponse> findNearByDrivers(double latitude, double longitude, double radius) {
        log.info("Finding drivers near lat: {} long: {} withing {}km", latitude, longitude, radius);

        Circle searchArea = new Circle(
                new Point(longitude, latitude),
                new Distance(radius, Metrics.KILOMETERS)
        );

        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisTemplate.opsForGeo()
                .radius(
                        DRIVERS_GEO_KEY,
                        searchArea,
                        RedisGeoCommands.
                                GeoRadiusCommandArgs.
                                newGeoRadiusArgs().
                                includeCoordinates().
                                includeDistance().
                                sortAscending()
                                .limit(10)
                );

        List<NearByDriverResponse> nearByDrivers = new ArrayList<>();

        if(results != null) {
            results.getContent().forEach(result -> {
                RedisGeoCommands.GeoLocation<String> location = result.getContent();
                nearByDrivers.add(new NearByDriverResponse(
                        location.getName(),
                        location.getPoint().getY(),
                        location.getPoint().getX(),
                        result.getDistance().getValue()
                ));
            });
        }

        log.info("Found {} drivers nearby", nearByDrivers.size());

        return nearByDrivers;
    }

    /*
    * Reomve driver when they go offline
    * Maps to Redis ZREM command.
    */
    public void removeDriver(String driverId) {
        log.info("Removing driver: {}", driverId);
        redisTemplate.opsForGeo().remove(DRIVERS_GEO_KEY, driverId);
    }
}
