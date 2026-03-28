package com.example.Rockstargames.controller;

import com.example.Rockstargames.dto.UserGameDto;
import com.example.Rockstargames.service.UserGameService;
import com.example.Rockstargames.utill.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1/user-game")
public class UserGameController {

    @Autowired
    private UserGameService userGameService;


    @PostMapping
    public ResponseEntity<APIResponse<String>> recordPurchase(
            @RequestBody @Valid UserGameDto userGameDto) {

        userGameService.recordPurchase(userGameDto);
        return new ResponseEntity<>(
                new APIResponse<>(200, "Purchase recorded successfully", null),
                HttpStatus.OK
        );
    }


    @GetMapping("/community")
    public ResponseEntity<APIResponse<List<Map<String, Object>>>> getCommunityFeed() {
        List<Map<String, Object>> feed = userGameService.getCommunityFeed();
        return new ResponseEntity<>(
                new APIResponse<>(200, "Community feed fetched", feed),
                HttpStatus.OK
        );
    }


    @GetMapping("/my-library")
    public ResponseEntity<APIResponse<List<UserGameDto>>> getMyLibrary(
            @RequestParam String username) {

        List<UserGameDto> library = userGameService.getMyLibrary(username);
        return new ResponseEntity<>(
                new APIResponse<>(200, "Library fetched", library),
                HttpStatus.OK
        );
    }
}
