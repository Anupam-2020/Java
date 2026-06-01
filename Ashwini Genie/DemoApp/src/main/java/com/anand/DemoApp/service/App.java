package com.anand.DemoApp.service;

import com.anand.DemoApp.components.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class App {

    @Autowired
    @Qualifier("petrolEngine")
    private Engine engine;

    public void drive() {
        int res = engine.start();

        if(res >= 1) System.out.println("Engine running");
        else System.out.println("Engine failed.");
    }
}
