package com.stackroute.userservice.userDTO;

import com.stackroute.userservice.model.User;

public class UserDTO {
    public String userEmail;
    public String userPassword;
    public enum Type{
        Owner,
        Player
    };
    private User.Type userType;

    public UserDTO() {
    }

    public UserDTO(String userEmail, String userPassword, User.Type userType) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType=" + userType +
                '}';
    }
}
