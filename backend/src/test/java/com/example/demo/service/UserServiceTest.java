package com.example.demo.service;

import com.example.demo.model.User;
import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void getUsers() throws Exception {
        try {
            String result = "";
            URI authorizationURI = new URIBuilder("https://projekt-mohammad.ddns.net/realms/diplom-projekt/protocol/openid-connect/token").build();
            WebClient webclient = WebClient.builder().build();
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.put("grant_type", Collections.singletonList("password"));
            formData.put("client_id", Collections.singletonList("angular-client"));
            formData.put("username", Collections.singletonList("user"));
            formData.put("password", Collections.singletonList("user"));

            result = webclient.post()
                    .uri(authorizationURI)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            result = result.split(":", 2)[1];
            result = result.split("\"", 2)[1];
            result = result.split("\"", 2)[0];

            List<User> userList = userService.getUsers("Bearer " + result);
            assertThat(userList).isNotEmpty();

        } catch (Exception e) {
            System.out.println("Can't obtain an access token from Keycloak!");
            throw new Exception(e);
        }
    }
}
