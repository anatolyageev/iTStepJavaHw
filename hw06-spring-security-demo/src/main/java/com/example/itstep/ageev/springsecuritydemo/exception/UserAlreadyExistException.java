package com.example.itstep.ageev.springsecuritydemo.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(final String message) {
        super(message);
    }
}
