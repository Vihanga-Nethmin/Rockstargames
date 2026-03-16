package com.example.Rockstargames.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {
    @Id
    private String gameId;
    private String title;
    private String description;
    private String price;
}
