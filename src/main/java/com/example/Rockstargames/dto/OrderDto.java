package com.example.Rockstargames.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "price is mandatory")
    private String price;


}
