package com.example.Rockstargames.service.impl;

import com.example.Rockstargames.dto.PaymentDto;
import com.example.Rockstargames.entity.Customer;
import com.example.Rockstargames.entity.Payment;
import com.example.Rockstargames.exception.CustomException;
import com.example.Rockstargames.repository.CustomerRepository;
import com.example.Rockstargames.repository.PaymentRepository;
import com.example.Rockstargames.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {



    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void save(PaymentDto paymentdto) {
        if (paymentdto==null){
            throw new NullPointerException("PaymentDto is null");
        }
        if (paymentRepository.existsById(paymentdto.getPayment_id())){

            throw new CustomException("Customer already exists");


        }
        paymentRepository.save(modelMapper.map(paymentdto, Payment.class));


    }

    @Override
    public void update(PaymentDto paymentdto) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<PaymentDto> getAll() {
        return List.of();
    }
}
