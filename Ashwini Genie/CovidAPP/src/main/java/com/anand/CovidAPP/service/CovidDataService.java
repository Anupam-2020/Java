package com.anand.CovidAPP.service;


import com.anand.CovidAPP.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CovidDataService {


    @Autowired
    RestTemplate restTemplate;

    public Integer getCovidData(String cityName, String state) {
       Map<String, Object> map = restTemplate.getForObject(Util.COVID_DATA_API, Map.class);
       Map<String, Object> cityObjectMap = (Map<String, Object>) map.get(state);
       Map<String, Object> districtData = (Map<String, Object>) cityObjectMap.get("districtData");
       Map<String, Object> city = (Map<String, Object>) districtData.get(cityName);
        return (Integer) city.get("active");
    }
}
