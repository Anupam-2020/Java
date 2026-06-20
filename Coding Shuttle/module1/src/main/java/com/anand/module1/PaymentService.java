package com.anand.module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    PaymentService() {
        System.out.println("Payment constructor");
    }

    public void pay() {
        System.out.println("Paying...");
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("After initialization");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("Before destroy");
    }
}
