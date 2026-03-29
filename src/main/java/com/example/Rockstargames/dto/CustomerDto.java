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
    private String customer_id;

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "[\\p{L} .'-]+$", message = "customer name is Incorrect")
    private String name;



    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;
}