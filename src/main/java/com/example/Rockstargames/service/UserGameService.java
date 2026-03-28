package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.UserGameDto;
import com.example.Rockstargames.entity.UserGame;
import com.example.Rockstargames.repository.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserGameService {

    @Autowired
    private UserGameRepository userGameRepository;


    public void recordPurchase(UserGameDto dto) {
        if (userGameRepository.existsByUsernameAndGameId(dto.getUsername(), dto.getGameId())) {
            return;
        }
        UserGame entity = new UserGame(
                dto.getUsername(),
                dto.getGameId(),
                dto.getGameTitle(),
                dto.getGamePrice(),
                dto.getImageUrl(),
                dto.getPurchasedDate() != null ? dto.getPurchasedDate() : LocalDate.now()
        );
        userGameRepository.save(entity);
    }

    public List<Map<String, Object>> getCommunityFeed() {
        List<UserGame> all = userGameRepository.findAll();

        // Group purchases by username
        Map<String, List<UserGame>> byUser = all.stream()
                .collect(Collectors.groupingBy(UserGame::getUsername));

        List<Map<String, Object>> result = new ArrayList<>();

        byUser.forEach((username, purchases) -> {
            Map<String, Object> userEntry = new LinkedHashMap<>();
            userEntry.put("username", username);

            List<Map<String, Object>> gamesList = purchases.stream().map(ug -> {
                Map<String, Object> g = new LinkedHashMap<>();
                g.put("gameId",        ug.getGameId());
                g.put("gameTitle",     ug.getGameTitle());
                g.put("gamePrice",     ug.getGamePrice());
                g.put("imageUrl",      ug.getImageUrl());
                g.put("purchasedDate", ug.getPurchasedDate() != null
                        ? ug.getPurchasedDate().toString() : "");
                return g;
            }).collect(Collectors.toList());

            userEntry.put("games", gamesList);
            userEntry.put("totalGames", purchases.size());
            result.add(userEntry);
        });

        result.sort((a, b) ->
                Integer.compare((int) b.get("totalGames"), (int) a.get("totalGames")));

        return result;
    }


    public List<UserGameDto> getMyLibrary(String username) {
        return userGameRepository.findByUsername(username).stream().map(ug -> {
            UserGameDto dto = new UserGameDto();
            dto.setUsername(ug.getUsername());
            dto.setGameId(ug.getGameId());
            dto.setGameTitle(ug.getGameTitle());
            dto.setGamePrice(ug.getGamePrice());
            dto.setImageUrl(ug.getImageUrl());
            dto.setPurchasedDate(ug.getPurchasedDate());
            return dto;
        }).collect(Collectors.toList());
    }
}
