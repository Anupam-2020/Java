package com.anand.module1.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    CakeBaker(
            @Qualifier("chocoFrost") Frosting frosting,
            @Qualifier("strawSyrup") Syrup syrup
    ) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake() {
        System.out.println(
                "Cake is baked with "+frosting.getFrostingType()+" and "+syrup.getSyrupType()
        );
    }
}
