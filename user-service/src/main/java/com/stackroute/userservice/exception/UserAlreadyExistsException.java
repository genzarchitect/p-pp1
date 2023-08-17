package com.stackroute.userservice.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String userAlreadyExistsInDb) {
        super(userAlreadyExistsInDb);
    }
}
>>>>>>> d8d8cbb25adbb332da766934a088c850053eb5ee
