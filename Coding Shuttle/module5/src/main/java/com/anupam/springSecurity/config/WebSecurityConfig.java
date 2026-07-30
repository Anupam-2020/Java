package com.anupam.springSecurity.config;

import com.anupam.springSecurity.entities.enums.Permission;
import com.anupam.springSecurity.filter.JwtAuthFilter;
import com.anupam.springSecurity.filter.LoggingFilter;
import com.anupam.springSecurity.handler.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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

import static com.anupam.springSecurity.entities.enums.Permission.POST_DELETE;
import static com.anupam.springSecurity.entities.enums.Permission.POST_UPDATE;
import static com.anupam.springSecurity.entities.enums.Role.ADMIN;
import static com.anupam.springSecurity.entities.enums.Role.CREATOR;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final PasswordEncoder passwordEncoder;
    private final LoggingFilter loggingFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    private static final String[] publicRoutes = {
            "/posts", "/error", "/public/**", "/auth/**", "/home.html"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)  throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(publicRoutes).permitAll()
//                                .requestMatchers("/posts/**").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/posts/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/posts/**")
                                    .hasAnyRole(ADMIN.name(), CREATOR.name())
                                .requestMatchers(HttpMethod.POST, "/posts/**")
                                    .hasAnyAuthority(Permission.POST_CREATE.name())
//                                .requestMatchers(HttpMethod.GET, "/posts/**")
//                                    .hasAuthority(Permission.POST_VIEW.name())
                                .requestMatchers(HttpMethod.PUT, "/posts/**")
                                    .hasAuthority(POST_UPDATE.name())
                                .requestMatchers(HttpMethod.DELETE, "/posts/**")
                                .hasAuthority(POST_DELETE.name())
                                .anyRequest().authenticated())
                .csrf(csrfConfig -> csrfConfig.disable()) // disable CSRF for stateless APIs. For jwt based authentication, we don't need CSRF protection as we are not using cookies for authentication.
                .sessionManagement(sessionConfig ->
                        sessionConfig.
                                sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS) // types of session management - STATELESS, STATEFUL, IF_REQUIRED
                )
                .addFilterBefore(loggingFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(oauth2Config -> oauth2Config
                        .failureUrl("/login?error=true") // Specify the URL to redirect to in case of authentication failure.
                        .successHandler(oAuth2SuccessHandler)
                );
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
