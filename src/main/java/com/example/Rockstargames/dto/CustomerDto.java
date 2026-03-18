package com.example.Rockstargames.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @NotNull(message = "Customer Id is mandatory")
    private String id;

    @NotBlank
    @Pattern(regexp = "[\\p{L} .'-]+$",message = "customer name is Incorrect")

    private String name;

    @Size(min = 10,max = 100,message = "MIN 10 & Max 100")
    private String address;


}
