package com.anand.DemoApp.controller;

import com.anand.DemoApp.service.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("engine")
public class EngineController {

    @Autowired
    App app;

    @GetMapping("/check")
    public void checkEngine() {
        app.drive();
    }
}
