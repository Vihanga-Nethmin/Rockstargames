package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    void save(CustomerDto customerDto);
    void update(CustomerDto customerDto);
    void delete(String id);
 List<CustomerDto> getAll();
}

