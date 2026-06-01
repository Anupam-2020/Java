package com.anand.studentManagement.exceptionHandler;

public class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(String message) {
        super(message);
    }
}
