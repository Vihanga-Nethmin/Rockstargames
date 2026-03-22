package com.example.Rockstargames.controller;

import com.example.Rockstargames.dto.LibraryDto;
import com.example.Rockstargames.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1/librari")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/all")
    public List<LibraryDto> getAlllibrary() {
        return libraryService.getAll();
    }
}
