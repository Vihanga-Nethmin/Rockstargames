package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.dto.GameDto;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    void save(GameDto gameDto);
    void update(GameDto gameDto);
}
