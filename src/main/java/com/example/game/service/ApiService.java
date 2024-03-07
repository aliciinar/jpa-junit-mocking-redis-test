package com.example.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.game.data.Character;

import java.util.Arrays;


@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private static final String CHAHRACTER_API = "https://rickandmortyapi.com/api/character";

    public Character getAllCharacter() {

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<com.example.game.data.Character> response = restTemplate.exchange(CHAHRACTER_API, HttpMethod.GET,
                entity, Character.class);

        return response.getBody();
    }
}