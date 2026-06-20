package com.anupam.springSecurity.handler;

import com.anupam.springSecurity.entities.User;
import com.anupam.springSecurity.services.JwtService;
import com.anupam.springSecurity.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    private final UserService userService;
    private final JwtService jwtService;

    @Value("${deploy.env}")
    private String deployEnv;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        DefaultOAuth2User user = (DefaultOAuth2User) token.getPrincipal();
        String email = user.getAttribute("email");

        User userDet = userService.getUserByEmail(email);

        if (userDet == null) {
            User newUser = User.builder()
                    .name(user.getAttribute("name"))
                    .email(email)
                    .build();

            userDet = userService.save(newUser);
        }

        String accessToken = jwtService.generateAccessToken(userDet);
        String refreshToken = jwtService.generateRefreshToken(userDet);

        Cookie cookie = new Cookie("refreshToken", refreshToken); // Create a cookie with the token
        cookie.setHttpOnly(true); // Set the HttpOnly flag to prevent JavaScript access
        cookie.setSecure("production".equals(deployEnv));
        response.addCookie(cookie);

        String frontEndUrl = "http://localhost:8080/home.html?token=" + accessToken;

//        getRedirectStrategy().sendRedirect(request, response, frontEndUrl);
        response.sendRedirect(frontEndUrl);
    }
}
