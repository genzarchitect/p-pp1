package com.stackroute.userservice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String noUserFound) {
        super(noUserFound);
    }
}
