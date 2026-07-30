package com.anupam.ecommerce.api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalLoggingFilter implements GlobalFilter, Ordered { // This class implements the `GlobalFilter` interface, which allows us to define a filter that will be applied to all incoming requests.
    // It also implements the `Ordered` interface, which allows us to specify the order in which this filter will be executed relative to other filters.
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) { // In this method, we can log the request and response details.
        // `Mono` is a reactive type that represents a single value or an empty value. We can use it to perform asynchronous operations.
        // The `chain` represents the next filter in the chain, and we can use it to continue processing the request.
        // The `exchange` represents the current request and response, and we can use it to access request and response details.
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("GlobalLoggingFilter: Response sent for path: {}", exchange.getRequest().getPath());
            System.out.println("GlobalLoggingFilter: Response sent for path: " + exchange.getResponse().getStatusCode());
        }));
    }

    @Override
    public int getOrder() {
        return 5; // The order of the filter. Lower values have higher priority. We can set it to any value based on our requirement.
    }
}
