package com.stackroute.userservice.service;

import com.stackroute.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User addUsersToDB(User user);

    public User getUserByEmail(String userEmail);
    public boolean deleteUser(String userEmail);

    public User updateUserByEmail(String userEmail,User user);



}
