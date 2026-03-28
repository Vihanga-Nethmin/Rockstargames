package com.example.Rockstargames.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_games")
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "game_id", nullable = false)
    private String gameId;

    @Column(name = "game_title", nullable = false)
    private String gameTitle;

    @Column(name = "game_price")
    private String gamePrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "purchased_date")
    private LocalDate purchasedDate;

    public UserGame() {}

    public UserGame(String username, String gameId, String gameTitle,
                    String gamePrice, String imageUrl, LocalDate purchasedDate) {
        this.username      = username;
        this.gameId        = gameId;
        this.gameTitle     = gameTitle;
        this.gamePrice     = gamePrice;
        this.imageUrl      = imageUrl;
        this.purchasedDate = purchasedDate;
    }

    public Long getId()                        { return id; }
    public void setId(Long id)                 { this.id = id; }

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

    public LocalDate getPurchasedDate()                    { return purchasedDate; }
    public void setPurchasedDate(LocalDate purchasedDate)  { this.purchasedDate = purchasedDate; }
}
