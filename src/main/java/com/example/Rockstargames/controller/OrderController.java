package com.example.Rockstargames.controller;


import com.example.Rockstargames.dto.OrderDto;
import com.example.Rockstargames.service.OrderService;
import com.example.Rockstargames.utill.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> addOrder(@RequestBody @Valid  OrderDto orderDto)  {
        orderService.save(orderDto);
        return new ResponseEntity<>(new APIResponse<>(200,"Order Added",null), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<APIResponse<String>> updateOrder(@RequestBody OrderDto orderDto) {
        orderService.update(orderDto);
        return new ResponseEntity<>(new APIResponse<>(201,"Order Updated",null), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<String>> deleteOrder(@PathVariable String id) {
        orderService.delete(id);
        return new ResponseEntity<>(new APIResponse<>(200,"Order Deleted",null), HttpStatus.OK);
    }





}