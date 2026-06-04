package com.anupam.module2.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder // This annotation generates a builder pattern for the class, allowing you to create instances of ApiError using a fluent API. It provides a convenient way to set the properties of the ApiError object when constructing it, improving code readability and maintainability.
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
