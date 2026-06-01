package com.anand.module1.assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocoFrost")
public class ChocolateFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "chocolate frosting type";
    }
}
