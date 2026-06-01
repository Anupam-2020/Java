package com.anand.SenondApp.service;

import com.anand.SenondApp.component.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class App {

    @Autowired
    @Qualifier("DE")
    Engine engine;

    public void drive() {
        int res = engine.start();

        if(res >= 1) System.out.println("Engine started");
        else System.out.println("Engine is damaged");
    }
}
