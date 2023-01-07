package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public @Data class User {

    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
