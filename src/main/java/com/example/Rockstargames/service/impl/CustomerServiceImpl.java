package com.example.Rockstargames.service.impl;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.entity.Customer;
import com.example.Rockstargames.exception.CustomException;
import com.example.Rockstargames.repository.CustomerRepository;
import com.example.Rockstargames.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder; // ✅ inject PasswordEncoder

    @Override
    public void save(CustomerDto customerDto) {
        if (customerDto == null) {
            throw new NullPointerException("CustomerDto is null");
        }
        if (customerRepository.existsById(customerDto.getCustomer_id())) {
            throw new CustomException("Customer already exists");
        }

        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        customerRepository.save(customer);
    }

    @Override
    public void update(CustomerDto customerDto) {
        if (customerDto == null) {
            throw new NullPointerException("CustomerDto is null");
        }
        if (!customerRepository.existsById(customerDto.getCustomer_id())) {
            throw new CustomException("Customer not found");
        }

        Customer customer = modelMapper.map(customerDto, Customer.class);

        if (customerDto.getPassword() != null && !customerDto.getPassword().isEmpty()) {
            customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        } else {
            String existingPassword = customerRepository.findById(customerDto.getCustomer_id())
                    .map(Customer::getPassword)
                    .orElseThrow(() -> new CustomException("Customer not found"));
            customer.setPassword(existingPassword);
        }

        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        if (id == null) {
            throw new NullPointerException("Customer id is null");
        }
        if (!customerRepository.existsById(id)) {
            throw new CustomException("Customer not found");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> getAll() {
        return modelMapper.map(
                customerRepository.findAll(),
                new TypeToken<List<CustomerDto>>() {}.getType()
        );
    }
}