package com.anand.module1.assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("syrupFrost")
public class ChcoclateSyrup implements Syrup {
    @Override
    public String getSyrupType() {
        return "syrup type";
    }
}
