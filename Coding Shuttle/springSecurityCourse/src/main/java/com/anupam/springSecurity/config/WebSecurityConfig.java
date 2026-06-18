package com.anupam.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)  throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/posts", "/error", "/public/**").permitAll()
                                .requestMatchers("/posts/**").hasAnyRole("ADMIN")
                                .anyRequest()
                                .authenticated())
//                .csrf(csrfConfig -> csrfConfig.disable()) // Disable CSRF protection for simplicity.
                .sessionManagement(sessionConfig ->
                        sessionConfig.
                                sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS) // types of session management - STATELESS, STATEFUL, IF_REQUIRED
                );
//                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }


    @Bean
    UserDetailsService myMemoryUserDetailsService() {
        UserDetails normalUser = User
                .withUsername("Anupam")
                .password(passwordEncoder().encode("anand"))
                .roles("USER")
                .build();

        UserDetails adminUser = User
                .withUsername("Anand")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
