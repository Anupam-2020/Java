package com.codingshuttle.youtube.hospitalManagement.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(UsernameNotFoundException exception) {
        ApiError apiError = ApiError.builder().error("Username not found with name "+exception.getMessage()).statusCode(HttpStatus.NOT_FOUND).build();
//        ApiError apiError = new ApiError("Username not found with name "+exception.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleJwtException() {
        ApiError apiError = ApiError.builder().error("Access denied: Insufficient permissions").statusCode(HttpStatus.FORBIDDEN).build();
        return ResponseEntity.status(apiError.getStatusCode()).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception e) {
        ApiError error = ApiError.builder().error("An unexpected error occurred: "+ e.getMessage()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(error.getStatusCode()).body(error);
    }
}
