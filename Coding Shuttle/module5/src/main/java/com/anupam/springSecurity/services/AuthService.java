package com.anupam.springSecurity.services;

import com.anupam.springSecurity.dto.LoginDto;
import com.anupam.springSecurity.entities.SessionEntity;
import com.anupam.springSecurity.entities.User;
import com.anupam.springSecurity.repositories.SessionRepository;
import jakarta.transaction.Transactional;
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
    private final SessionRepository sessionRepository;

    @Transactional
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        sessionRepository.deleteByUserId(user.getId());

        SessionEntity session = new SessionEntity();
        session.setUserId(user.getId());
        String token = jwtService.generateToken(user);
        session.setToken(token);
        sessionRepository.save(session);
        return token;
    }
}
