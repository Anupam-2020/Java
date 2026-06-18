package com.anupam.springSecurity.controllers;

import com.anupam.springSecurity.dto.LoginDto;
import com.anupam.springSecurity.dto.SignUpDto;
import com.anupam.springSecurity.dto.UserDto;
import com.anupam.springSecurity.services.AuthService;
import com.anupam.springSecurity.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto) {
        UserDto userDto = userService.signUp(signUpDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        String token = authService.login(loginDto);
        Cookie cookie = new Cookie("token", token); // Create a cookie with the token
        cookie.setHttpOnly(true); // Set the HttpOnly flag to prevent JavaScript access
        cookie.setSecure(true); // Set the Secure flag to ensure it's sent over HTTPS
        cookie.setPath("/"); // Set the path for which the cookie is valid
        response.addCookie(cookie); // Add the cookie to the response

        return ResponseEntity.ok(token);
    }
}
