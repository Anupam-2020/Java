package com.anupam.ecommerce.order_service.controllers;

import com.anupam.ecommerce.order_service.clients.InventoryOpenFeignClient;
import com.anupam.ecommerce.order_service.dto.OrderRequestDto;
import com.anupam.ecommerce.order_service.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
@Slf4j
@RefreshScope // RefreshScope annotation is used to indicate that the bean should be refreshed when configuration changes are detected. This is useful in a microservices architecture where configuration properties may change at runtime, and you want the bean to pick up those changes without restarting the application.
public class OrdersController {

    @Value("${my.variable}")
    private String myVariable;

    private final OrdersService ordersService;
    private final InventoryOpenFeignClient inventoryOpenFeignClient;

//    @GetMapping("/helloOrders")
//    public String helloOrders(@RequestHeader(name = "X-User-Id") Long userId) {
//        return "hello from order service user id is: "+userId;
//    }

    @GetMapping("/helloOrders")
    public String helloOrders() {
        return "hello from order service user id is: "+myVariable;
    }


    @PostMapping("/create-order")
    public ResponseEntity<OrderRequestDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderRequestDto orderRequestDto1 = ordersService.createOrder(orderRequestDto);
        return ResponseEntity.ok(orderRequestDto1);
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders() {
        log.info("Fetching all orders via controller");
        List<OrderRequestDto> orders = ordersService.getAllOrders();

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable  Long id) {
        log.info("Fetching order with id: {}", id);
        OrderRequestDto order = ordersService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
}
