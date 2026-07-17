package com.anupam.linkedinProject.userService.controller;

import com.anupam.linkedinProject.userService.dto.LoginRequestDto;
import com.anupam.linkedinProject.userService.dto.SignupRequestDto;
import com.anupam.linkedinProject.userService.dto.UserDto;
import com.anupam.linkedinProject.userService.service.AuthService;
import com.anupam.linkedinProject.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        UserDto userDto = authService.signUp(signupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        String userDto = authService.login(loginRequestDto);
        return ResponseEntity.ok(userDto);
    }
}
