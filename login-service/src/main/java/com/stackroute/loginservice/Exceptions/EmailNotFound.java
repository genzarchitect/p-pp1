package com.stackroute.loginservice.Exceptions;

public class EmailNotFound extends RuntimeException {
    public EmailNotFound(String Incorrect) {
        super(Incorrect);
    }
}

