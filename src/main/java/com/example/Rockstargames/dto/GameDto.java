package com.example.Rockstargames.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {

    @NotNull(message = "Game Id is mandatory")
    private String game_id;

    @NotBlank(message = "description mandatory")
    private String description;

    @NotNull(message = "Price is mandatory")
    @Pattern(regexp = "^Rs\\s?\\d+(\\.\\d{1,2})?$", message = "Price must be in format Rs 100 or Rs 100.00")
    private String price;

    // Add these two fields (you are sending them in JSON)
    @NotBlank(message = "Title")
    private String title;
}
