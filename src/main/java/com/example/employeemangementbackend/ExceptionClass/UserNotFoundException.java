package com.example.employeemangementbackend.ExceptionClass;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}