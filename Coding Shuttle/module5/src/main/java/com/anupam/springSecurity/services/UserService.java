package com.anupam.springSecurity.services;

import com.anupam.springSecurity.dto.SignUpDto;
import com.anupam.springSecurity.dto.UserDto;
import com.anupam.springSecurity.entities.User;
import com.anupam.springSecurity.exceptions.ResourceNotFoundException;
import com.anupam.springSecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("Username not found exception -> "+username));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new BadCredentialsException("User not found id"+userId));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user = userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()) {
            throw new BadCredentialsException("User with email already exists");
        }

        User toCreate = modelMapper.map(signUpDto, User.class);
        toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
        User savedUser = userRepository.save(toCreate);

        return modelMapper.map(savedUser, UserDto.class);
    }

}
