package com.example.demo.service;

import com.example.demo.model.User;
//import org.keycloak.Token;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers(String token) {
        String url = "https://projekt-mohammad.ddns.net/admin/realms/diplom-projekt/users";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        ResponseEntity<User[]> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);

        List<User> users = Arrays.asList(response.getBody());
        return users;
    }
}
