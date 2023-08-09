package com.stackroute.loginservice.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
    public class User {
        @Id
        @Column(columnDefinition = "VARCHAR(50)")
        private String useremail;
        private String password;

        @Enumerated(EnumType.STRING)
        @Column(nullable=false, unique = true)
        private UserType name;


    }

