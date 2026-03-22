package com.example.Rockstargames.service.impl;

import com.example.Rockstargames.dto.LibraryDto;
import com.example.Rockstargames.service.LibraryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Override
    public List<LibraryDto> getAll() {
        return List.of();
    }
}
