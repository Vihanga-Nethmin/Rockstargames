package com.example.Rockstargames.service;

import com.example.Rockstargames.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void save(OrderDto orderdto);
    void update(OrderDto orderdto);
    void delete(String id);
    List<OrderDto> getAll();

}
