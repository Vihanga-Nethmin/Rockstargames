package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    void save(CustomerDto customerDto);
}
