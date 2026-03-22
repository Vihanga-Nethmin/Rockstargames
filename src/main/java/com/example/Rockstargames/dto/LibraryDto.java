package com.example.Rockstargames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {
    private String library_id;
    private String customer_id;
    private String game_id;
    private String purchase_date;

}
