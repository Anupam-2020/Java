package com.anupam.linkedinProject.userService.service;

import com.anupam.linkedinProject.userService.dto.LoginRequestDto;
import com.anupam.linkedinProject.userService.dto.SignupRequestDto;
import com.anupam.linkedinProject.userService.dto.UserDto;
import com.anupam.linkedinProject.userService.entity.User;
import com.anupam.linkedinProject.userService.exception.BadRequestException;
import com.anupam.linkedinProject.userService.exception.ResourceNotFoundException;
import com.anupam.linkedinProject.userService.repository.UserRepository;
import com.anupam.linkedinProject.userService.utils.BCrypt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public UserDto signUp(SignupRequestDto signupRequestDto) {
        log.info("Signing up a user with email: {}", signupRequestDto.getEmail());

        boolean exists = userRepository.existsByEmail(signupRequestDto.getEmail());
        if(exists) {
            throw new BadRequestException("User already exists");
        }

        User user = User.builder()
                .email(signupRequestDto.getEmail())
                .name(signupRequestDto.getName())
                .password(BCrypt.hash(signupRequestDto.getPassword()))
                .build();

//        User user = modelMapper.map(signupRequestDto, User.class);
//        user.setPassword(BCrypt.hash(signupRequestDto.getPassword()));

        user = userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    public String login(LoginRequestDto loginRequestDto) {
        log.info("Login request for user with email: {}", loginRequestDto.getEmail());

        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(()
                -> new ResourceNotFoundException("Incorrect credential: "+loginRequestDto.getEmail()));

        boolean isPasswordMatch = BCrypt.match(loginRequestDto.getPassword(), user.getPassword());

        if(!isPasswordMatch) {
            throw new BadRequestException("Incorrect credential");
        }

        return jwtService.generateAccessToken(user);
    }
}
