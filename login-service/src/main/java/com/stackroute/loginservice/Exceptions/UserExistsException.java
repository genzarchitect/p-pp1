package com.stackroute.loginservice.Exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String userAlreadyExist) {
        super(userAlreadyExist);
    }


}
