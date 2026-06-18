package com.anupam.springSecurity.config;

import com.anupam.springSecurity.filter.JwtAuthFilter;
import com.anupam.springSecurity.filter.LoggingFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final PasswordEncoder passwordEncoder;
    private final LoggingFilter loggingFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)  throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/posts", "/error", "/public/**", "/auth/**").permitAll()
//                                .requestMatchers("/posts/**").hasAnyRole("ADMIN")
                                .anyRequest()
                                .authenticated())
                .csrf(csrfConfig -> csrfConfig.disable()) // disable CSRF for stateless APIs. For jwt based authentication, we don't need CSRF protection as we are not using cookies for authentication.
                .sessionManagement(sessionConfig ->
                        sessionConfig.
                                sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS) // types of session management - STATELESS, STATEFUL, IF_REQUIRED

                )
                .addFilterBefore(loggingFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


//    @Bean
    UserDetailsService myMemoryUserDetailsService() {
        UserDetails normalUser = User
                .withUsername("Anupam")
                .password(passwordEncoder.encode("anand"))
                .roles("USER")
                .build();

        UserDetails adminUser = User
                .withUsername("Anand")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }
}
