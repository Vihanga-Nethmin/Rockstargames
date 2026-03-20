package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.dto.GameDto;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface GameService {
    void save(GameDto gameDto);
    void update(GameDto gameDto);
    void delete(String id);
    List<GameDto> getAll();
}
