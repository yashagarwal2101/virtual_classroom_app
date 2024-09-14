package com.ksolves.vitrual_classromm_backend.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String email) {
        super("user with email " + email + " already exists");
    }
}
