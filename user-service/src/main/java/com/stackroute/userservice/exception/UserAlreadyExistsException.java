package com.stackroute.userservice.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String userAlreadyExistsInDb) {
        super(userAlreadyExistsInDb);
    }
}
