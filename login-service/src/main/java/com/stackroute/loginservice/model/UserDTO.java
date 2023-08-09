package com.stackroute.loginservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UserDTO {
    private String userEmail;
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, unique = true)
    private UserType name;
}
