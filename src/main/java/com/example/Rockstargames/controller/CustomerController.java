package com.example.Rockstargames.controller;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.service.CustomerService;
import com.example.Rockstargames.utill.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<APIResponse<String>>addCustomer(@RequestBody @Valid  CustomerDto customerDto) {
        customerService.save(customerDto);
        return new ResponseEntity<>(new APIResponse<>(201,"Customer Saved",null), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<APIResponse<String>>updateCustomer(@RequestBody @Valid  CustomerDto customerDto) {
        customerService.update(customerDto);
        return new ResponseEntity<>(new APIResponse<>(200,"Customer Updated",null), HttpStatus.CREATED);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<String>>deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
        return new ResponseEntity<>(new APIResponse<>(200,"Customer Deleted",null), HttpStatus.OK);
    }
}
