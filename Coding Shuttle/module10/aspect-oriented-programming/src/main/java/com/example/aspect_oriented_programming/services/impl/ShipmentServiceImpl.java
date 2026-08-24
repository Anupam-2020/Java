package com.example.aspect_oriented_programming.services.impl;


import com.example.aspect_oriented_programming.aspect.MyLogging;
import com.example.aspect_oriented_programming.services.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {

    @Override
    @MyLogging
    public String orderPackage(Long orderId) {
        try {
            log.info("Processing the order...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error occurred while processing the order", e);
        }

        return "Order has been processed successfully, orderId: " + orderId;
    }

    @Override
//    @Transactional
    public String trackPackage(Long orderId) {
        try {
            log.info("Tracking the order...");
            Thread.sleep(500);
            throw new RuntimeException("Exception occurred during trackPackage");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
