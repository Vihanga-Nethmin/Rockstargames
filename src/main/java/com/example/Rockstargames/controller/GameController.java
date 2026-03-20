package com.example.Rockstargames.controller;

import com.example.Rockstargames.dto.GameDto;
import com.example.Rockstargames.entity.Game;
import com.example.Rockstargames.repository.CustomerRepository;
import com.example.Rockstargames.service.GameService;
import com.example.Rockstargames.utill.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1/Game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<APIResponse<String>>addGame(@RequestBody @Valid GameDto gameDto) {
        gameService.save(gameDto);
        return new ResponseEntity<>(new APIResponse<>(200,"game Added",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse<String>>updateGame(@RequestBody @Valid GameDto gameDto) {
        gameService.update(gameDto);
        return new ResponseEntity<>(new APIResponse<>(201,"game Updated",null), HttpStatus.OK);
    }



}
