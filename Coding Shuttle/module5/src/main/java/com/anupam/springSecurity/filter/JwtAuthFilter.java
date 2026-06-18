package com.anupam.springSecurity.filter;

import com.anupam.springSecurity.entities.User;
import com.anupam.springSecurity.services.JwtService;
import com.anupam.springSecurity.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@RequiredArgsConstructor
// JwtAuthFilter is a custom filter that extends OncePerRequestFilter to handle JWT authentication for incoming requests. It checks the Authorization header for a valid JWT token, extracts the user ID from the token, retrieves the corresponding user from the database, and sets the authentication in the SecurityContextHolder if the user is valid. If any exception occurs during this process, it delegates the exception handling to a HandlerExceptionResolver.
public class JwtAuthFilter extends OncePerRequestFilter { // OncePerRequestFilter is a base class for filters that guarantees to be executed only once per request. It provides a doFilterInternal method that subclasses must implement to perform the actual filtering logic.

    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private final HandlerExceptionResolver handlerExceptionResolver;


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            final String requestTokenHeader = request.getHeader("Authorization"); // Retrieves the value of the "Authorization" header from the incoming HTTP request.
            // This header typically contains the JWT token prefixed with "Bearer".

            System.out.println("This is token ------> "+ requestTokenHeader);
            if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = requestTokenHeader.split("Bearer ")[1];

            Long userId = jwtService.getUserIdFromToken(token);

            if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null) { // Checks if the user ID extracted from the token is not null and if there is no existing authentication in the SecurityContextHolder.
                // SecurityContextHolder is a class that holds the security context for the current thread of execution.
                // It allows access to the authentication and security-related information for the current user.
                // That's why we are checking if the authentication is null, to avoid overwriting an existing authentication.
                User user = userService.getUserById(userId);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null, null);
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        filterChain.doFilter(request, response);
        } catch (Exception ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }
}
