package com.example.Rockstargames.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDto {
    @NotBlank
    private String username;
    @Email(message = "Invalid email format")
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String role;
}