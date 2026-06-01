package com.anand.DemoApp.components;


import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine {

    @Override
    public int start() {
        return 2;
    }
}
