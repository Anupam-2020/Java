package com.anand.CovidAPP.controller;


import com.anand.CovidAPP.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/covid-data")
public class CovidController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/citywise/{state}/{city}")
    public String getCovidCases(@PathVariable String city, @PathVariable String state) {
        Integer covidData = covidDataService.getCovidData(city, state);
        return "Total active case in "+state+"("+city+")"+" = "+covidData;
    }
}
