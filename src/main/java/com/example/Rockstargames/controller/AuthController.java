package com.example.Rockstargames.controller;

import com.example.Rockstargames.dto.AuthDto;
import com.example.Rockstargames.dto.RegisterDto;
import com.example.Rockstargames.service.UserService;
import com.example.Rockstargames.utill.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody RegisterDto registerDTO) {
        return ResponseEntity.ok(new APIResponse(200, "OK", userService.saveUser(registerDTO)));
    }

    @PostMapping("login")
    public ResponseEntity<APIResponse> loginUser(@RequestBody AuthDto authDTO) {
        // This will now return the user's role and a dummy token for your frontend
        Object result = userService.authenticate(authDTO);
        if (result != null) {
            return ResponseEntity.ok(new APIResponse(200, "Access Granted", result));
        }
        return ResponseEntity.status(401).body(new APIResponse(401, "Invalid Credentials", null));
    }
}