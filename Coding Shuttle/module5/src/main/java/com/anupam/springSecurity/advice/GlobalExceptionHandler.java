package com.anupam.springSecurity.advice;

import com.anupam.springSecurity.exceptions.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResponseNotFoundException(ResourceNotFoundException exception) {
//        ApiError apiError = new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND);
        ApiError apiError = ApiError.builder().error(exception.getMessage()).statusCode(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException exception) {
        ApiError apiError = ApiError.builder().statusCode(HttpStatus.UNAUTHORIZED).error(exception.getLocalizedMessage()).build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtException(JwtException exception) {
        ApiError apiError = ApiError.builder().statusCode(HttpStatus.UNAUTHORIZED).error(exception.getMessage()).build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(AuthenticationException exception) {
        ApiError apiError = ApiError.builder().statusCode(HttpStatus.FORBIDDEN).error(exception.getLocalizedMessage()).build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
    }
}
