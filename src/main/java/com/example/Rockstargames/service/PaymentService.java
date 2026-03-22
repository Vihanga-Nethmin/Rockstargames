package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    void save(PaymentDto paymentdto);
    void update(PaymentDto paymentdto);
    void delete(String id);
    List<PaymentDto> getAll();
}
