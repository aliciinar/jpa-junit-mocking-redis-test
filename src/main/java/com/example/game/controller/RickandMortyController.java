package com.example.game.controller;

import com.example.game.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.game.data.Character;

@RestController
@RequestMapping("/api/v1/rick/")
public class RickandMortyController {

    @Autowired
    private ApiService apiService;

    @GetMapping("getAllCharacters")
    public ResponseEntity<Character> getAllCustomer(){
        Character character = apiService.getAllCharacter();
        return new ResponseEntity<Character>(character, HttpStatus.OK);
    }
}
