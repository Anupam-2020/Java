package com.anupam.ecommerce.api_gateway.filters;

import com.anupam.ecommerce.api_gateway.service.JwtService;
import io.jsonwebtoken.Jwt;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class AuthorizationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthorizationGatewayFilterFactory.Config> {

    private final JwtService jwtService;

    public AuthorizationGatewayFilterFactory(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("AuthorizationGatewayFilterFactory: Checking user role for authorization");
//                if(!config.isEnabled)  return chain.filter(exchange);

                String userRole = exchange.getRequest().getHeaders().getFirst("X-User-Id");
                String authorizationHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
                if(userRole == null || !userRole.equals("ROLE_ADMIN")) {
                    exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.FORBIDDEN);
                    return exchange.getResponse().setComplete();
                }

               log.info("AuthorizationGatewayFilterFactory: User role is {}", userRole);

                String token = authorizationHeader.split("Bearer ")[1];
                Long userId = jwtService.getUserIdFromToken(token);

                exchange.getRequest()
                        .mutate()
                        .header("X-User-Id", userId.toString())
                        .build();

                return chain.filter(exchange);
            }
        };
    }

    @Data
    public static class Config {
        // Add any configuration properties here if needed
        private boolean isEnabled;
        private List<String> roles; // List of roles that are allowed to access the resource. This can be used to implement role-based access control (RBAC) in the filter.
    }
}
