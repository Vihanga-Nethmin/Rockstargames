package com.example.Rockstargames.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    @NotNull(message = "Payment Id is mandatory")
    private String payment_id;

    @NotNull(message = "Order Id is mandatory")
    private String order_id;

    @NotBlank(message = "Payment date is mandatory")
    private String payment_date;

    @NotBlank(message = "Payment method is mandatory")
    private String payment_method;

    @NotBlank(message = "Payment status is mandatory")
    private String payment_status;

    @NotBlank(message = "Transaction Id is mandatory")
    private String transaction_id;
}