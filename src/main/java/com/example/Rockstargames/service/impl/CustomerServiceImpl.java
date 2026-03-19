package com.example.Rockstargames.service.impl;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.entity.Customer;
import com.example.Rockstargames.exception.CustomException;
import com.example.Rockstargames.repository.CustomerRepository;
import com.example.Rockstargames.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CustomerDto customerDto) {

        if (customerDto==null){
            throw new NullPointerException("CustomerDto is null");
        }
        if (customerRepository.existsById(customerDto.getCustomer_id())){

            throw new CustomException("Customer already exists");


        }
        customerRepository.save(modelMapper.map(customerDto, Customer.class));



    }

    @Override
    public void update(CustomerDto customerDto) {

    }
}
