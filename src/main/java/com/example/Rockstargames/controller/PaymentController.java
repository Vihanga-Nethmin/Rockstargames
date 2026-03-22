package com.example.Rockstargames.controller;


import com.example.Rockstargames.dto.CustomerDto;
import com.example.Rockstargames.dto.PaymentDto;
import com.example.Rockstargames.service.CustomerService;
import com.example.Rockstargames.service.PaymentService;
import com.example.Rockstargames.utill.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1/payment")

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> addPayment(@RequestBody @Valid PaymentDto paymentDto) {
        paymentService.save(paymentDto);
        return new ResponseEntity<>(new APIResponse<>(201, "Payment Saved", null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<APIResponse<String>>updatePayment(@RequestBody @Valid  PaymentDto paymentDto) {
        paymentService.update(paymentDto);
        return new ResponseEntity<>(new APIResponse<>(200,"Payment Updated",null), HttpStatus.CREATED);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<String>>deletePayment(@PathVariable String id) {
        paymentService.delete(id);
        return new ResponseEntity<>(new APIResponse<>(200,"Payment Deleted",null), HttpStatus.OK);
    }













}
