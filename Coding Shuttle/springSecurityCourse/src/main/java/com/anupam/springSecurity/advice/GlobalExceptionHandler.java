package com.anupam.springSecurity.advice;

import com.anupam.springSecurity.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResponseNotFoundException(ResourceNotFoundException exception) {
//        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND);
        ApiError apiError = ApiError.builder().error(exception.getMessage()).statusCode(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
