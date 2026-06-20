package com.anupam.springSecurity.services;

import com.anupam.springSecurity.dto.LoginDto;
import com.anupam.springSecurity.dto.LoginResponseDto;
import com.anupam.springSecurity.entities.SessionEntityHomeWork;
import com.anupam.springSecurity.entities.User;
import com.anupam.springSecurity.repositories.SessionRepository;
import com.anupam.springSecurity.repositories.SessionRepositoryHomework;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final SessionService sessionService;
    private final SessionRepositoryHomework sessionRepositoryHomework;

//    @Transactional
    public LoginResponseDto login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        sessionRepositoryHomework.deleteByUserId(user.getId());

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

//        SessionEntityHomeWork sessionHW = SessionEntityHomeWork.builder()
//                .userId(user.getId())
//                .token(accessToken)
//                .build();

        sessionService.generateNewSession(user, refreshToken);

//        sessionRepositoryHomework.save(sessionHW);

        return LoginResponseDto.builder()
                .id(user.getId())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public LoginResponseDto refreshToken(String refreshToken) {
        Long userId = jwtService.getUserIdFromToken(refreshToken);
        sessionService.validateSession(refreshToken);
        User user = userService.getUserById(userId);

        String accessToken = jwtService.generateAccessToken(user);
        return LoginResponseDto.builder()
                .id(user.getId())
                .refreshToken(refreshToken)
                .accessToken(accessToken)
                .build();
    }
}
