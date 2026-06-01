package com.anand.module1.assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawSyrup")
public class StrawberrySyrup implements Syrup {
    @Override
    public String getSyrupType() {
        return "strawberry syrup";
    }
}
