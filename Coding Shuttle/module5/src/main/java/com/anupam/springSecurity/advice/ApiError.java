package com.anupam.springSecurity.advice;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    @Builder.Default
    private LocalDateTime timeStamp = LocalDateTime.now();
    private String error;
    private HttpStatus statusCode;

    public ApiError(String error, HttpStatus statusCode) {
        this.error = error;
        this.statusCode = statusCode;
    }
}
