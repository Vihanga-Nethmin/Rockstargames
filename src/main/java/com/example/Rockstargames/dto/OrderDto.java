package com.example.Rockstargames.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @NotNull(message = "Order Id is mandatory")
    private String order_id;

    @NotNull(message = "Game Id is mandatory")
    private String game_id;

    @NotNull(message = "Price is mandatory")
    @Pattern(regexp = "^Rs\\s?\\d+(\\.\\d{1,2})?$", message = "Price must be in format Rs 100 or Rs 100.00")
    private String price;


}
