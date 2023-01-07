package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceTest extends KeycloakAuthTestContainer {

    @Autowired
    UserService userService;

    @Test
    void getUsers() throws Exception {
        try {
            String token = getBearer("user","user");
            List<User> userList = userService.getUsers(token);
            assertThat(userList).isNotEmpty();
        } catch (Exception e) {
            System.out.println("Can't obtain an access token from Keycloak!");
            throw new Exception(e);
        }
    }
}
