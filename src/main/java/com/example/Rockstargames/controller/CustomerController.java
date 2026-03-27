package com.example.Rockstargames.controller;

import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.service.CustomerService;
import com.example.Rockstargames.utill.APIResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<APIResponse> addCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.save(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>(201, "Customer Saved", null));
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.update(customerDto);
        return ResponseEntity.ok(
                new APIResponse<>(200, "Customer Updated", null)
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse> deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.ok(
                new APIResponse<>(200, "Customer Deleted", null)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<CustomerDto>>> getAllCustomers() {
        return ResponseEntity.ok(
                new APIResponse<>(200, "Success", customerService.getAll())
        );
    }
}