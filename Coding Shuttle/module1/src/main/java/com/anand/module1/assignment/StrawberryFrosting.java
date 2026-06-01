package com.anand.module1.assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawFrost")
public class StrawberryFrosting implements Frosting{
    @Override
    public String getFrostingType() {
        return "frosting strawberry";
    }
}
