package com.example.usermanagement.domain.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String username) {
        super(String.format("User with username %s already exists. Please choose a different username.",username));
    }
}
