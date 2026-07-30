package com.anupam.ecommerce.api_gateway.filters;

import com.anupam.ecommerce.api_gateway.service.JwtService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {

    private final JwtService jwtService;

    public AuthenticationGatewayFilterFactory(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("AuthenticationGatewayFilterFactory: Checking user authentication");
//                if(!config.isEnabled) return chain.filter(exchange);

                String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
                if(authorizationHeader == null) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                String token = authorizationHeader.split("Bearer ")[1];
                Long userId = jwtService.getUserIdFromToken(token);

                exchange.getRequest()
                        .mutate()
                        .header("X-User-Id", userId.toString())
                        .build();

                return chain.filter(exchange); // Returns the Mono<Void> that represents the completion of the filter chain. This allows the request to continue through the filter chain and eventually reach the destination service.
            }
        };
    }

    @Data
    public static class Config {
        // Add any configuration properties here if needed
        private boolean isEnabled;
    }
}
