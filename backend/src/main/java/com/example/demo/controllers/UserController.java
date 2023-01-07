package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new ResponseEntity<List<User>>(userService.getUsers(token), HttpStatus.OK);
    }

    @GetMapping("/")
    public String hello(){
        return "hello";
    }
}
