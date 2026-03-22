package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.LibraryDto;
import com.example.Rockstargames.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LibraryService {
    List<LibraryDto> getAll();

}
