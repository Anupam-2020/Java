package com.anupam.ecommerce.api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingOrdersFilter extends AbstractGatewayFilterFactory<LoggingOrdersFilter.Config> { // This class is a custom filter that extends the `AbstractGatewayFilterFactory` class, which allows us to define a filter that can be configured with a name.
    // Unlike the `GlobalLoggingFilter`, this filter will only be applied to specific routes that we configure in the application properties or YAML file.

    public LoggingOrdersFilter() { // The constructor takes a `Config` class as a parameter, which allows us to define custom configuration properties for this filter. We can use this class to define any properties that we want to configure for this filter.
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) { //
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("Order Filter Pre: {}", exchange.getRequest());
                return chain.filter(exchange);
            }
        };
    }

    public static class Config { // This class is used to define any custom configuration properties for the `LoggingOrdersFilter`. We can add any properties that we want to configure for this filter. For example, we can add a property to enable or disable logging for this filter.

    }
}
