package com.example.Rockstargames.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class UserGameDto {

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "gameId is required")
    private String gameId;

    @NotBlank(message = "gameTitle is required")
    private String gameTitle;

    private String gamePrice;
    private String imageUrl;
    private LocalDate purchasedDate;

    public UserGameDto() {}

    public UserGameDto(String username, String gameId, String gameTitle,
                       String gamePrice, String imageUrl, LocalDate purchasedDate) {
        this.username      = username;
        this.gameId        = gameId;
        this.gameTitle     = gameTitle;
        this.gamePrice     = gamePrice;
        this.imageUrl      = imageUrl;
        this.purchasedDate = purchasedDate;
    }

    public String getUsername()                { return username; }
    public void setUsername(String username)   { this.username = username; }

    public String getGameId()                  { return gameId; }
    public void setGameId(String gameId)       { this.gameId = gameId; }

    public String getGameTitle()               { return gameTitle; }
    public void setGameTitle(String gameTitle) { this.gameTitle = gameTitle; }

    public String getGamePrice()               { return gamePrice; }
    public void setGamePrice(String gamePrice) { this.gamePrice = gamePrice; }

    public String getImageUrl()                { return imageUrl; }
    public void setImageUrl(String imageUrl)   { this.imageUrl = imageUrl; }

    public LocalDate getPurchasedDate()                   { return purchasedDate; }
    public void setPurchasedDate(LocalDate purchasedDate) { this.purchasedDate = purchasedDate; }
}
