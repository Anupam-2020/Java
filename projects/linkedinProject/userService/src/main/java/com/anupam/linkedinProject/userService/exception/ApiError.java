package com.anupam.linkedinProject.userService.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    @Builder.Default
    private LocalDateTime timeStamp = LocalDateTime.now();
    private String error;
    private HttpStatus statusCode;

//    public ApiError() {
//        timeStamp = LocalDateTime.now();
//    }

    public ApiError(String error, HttpStatus statusCode) {
        this();
        this.error = error;
        this.statusCode = statusCode;
    }
}
