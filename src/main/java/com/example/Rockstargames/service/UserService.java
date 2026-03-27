package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.AuthDto;
import com.example.Rockstargames.dto.AuthResponseDTO;
import com.example.Rockstargames.dto.RegisterDto;

public interface UserService {
    String saveUser(RegisterDto registerDTO);
    AuthResponseDTO authenticate(AuthDto authDTO);
}
