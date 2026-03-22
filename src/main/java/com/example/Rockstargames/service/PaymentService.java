package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    void save(PaymentDto paymentdto);
    void update(PaymentDto paymentdto);
    void delete(String id);
    List<PaymentDto> getAll();
}
