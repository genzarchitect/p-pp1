package com.stackroute.loginservice.Service;

import com.stackroute.loginservice.Exceptions.EmailNotFound;
import com.stackroute.loginservice.Exceptions.IncorrectPasswordException;
import com.stackroute.loginservice.Exceptions.UserExistsException;
import com.stackroute.loginservice.Exceptions.UserNotFoundException;
import com.stackroute.loginservice.model.User;

public interface LoginService {

    User registerUser(User user)throws UserExistsException;
    User authenticateUser(String email,String password) throws UserNotFoundException, IncorrectPasswordException;

    User forgotPassword(String email,User user)throws EmailNotFound;


}
