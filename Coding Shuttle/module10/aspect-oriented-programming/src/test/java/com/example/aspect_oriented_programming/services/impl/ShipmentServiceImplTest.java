package com.example.aspect_oriented_programming.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @Test
    void aopTestOrderPackage() {
        String orderString = shipmentService.orderPackage(-4L);
        log.info(orderString);
    }

    @Test
    void aopTestTrackPackage() {
        shipmentService.trackPackage(3L);
    }
}
