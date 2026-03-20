package com.example.Rockstargames.service.impl;

import com.example.Rockstargames.dto.GameDto;
import com.example.Rockstargames.entity.Game;
import com.example.Rockstargames.exception.CustomException;
import com.example.Rockstargames.repository.GameRepository;
import com.example.Rockstargames.service.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(GameDto gameDto) {
        if (gameDto==null){
            throw new NullPointerException("GameDto is null");
        }
        if (gameRepository.existsById(gameDto.getGame_id())){
            throw new CustomException("Game already exists");
        }
        gameRepository.save(modelMapper.map(gameDto, Game.class));



    }

    @Override
    public void update(GameDto gameDto) {
        if (gameDto==null){
            throw new NullPointerException("GameDto is null");
        }
        gameRepository.save(modelMapper.map(gameDto, Game.class));


    }

    @Override
    public void delete(String id) {
        if (id==null){
            throw new NullPointerException("Game id is null");
        }
        gameRepository.deleteById(id);

    }
}
