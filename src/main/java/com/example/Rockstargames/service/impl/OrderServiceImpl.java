package com.example.Rockstargames.service.impl;

import com.example.Rockstargames.dto.OrderDto;
import com.example.Rockstargames.entity.Game;
import com.example.Rockstargames.entity.Order;
import com.example.Rockstargames.exception.CustomException;
import com.example.Rockstargames.repository.CustomerRepository;
import com.example.Rockstargames.repository.OrderRepository;
import com.example.Rockstargames.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void save(OrderDto orderdto) {
        if (orderdto==null){
            throw new NullPointerException("orderdto is null");
        }
        if (orderRepository.existsById(orderdto.getOrder_id())){
            throw new CustomException("order already exists");
        }
        orderRepository.save(modelMapper.map(orderdto, Order.class));


    }

    @Override
    public void update(OrderDto orderdto) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<OrderDto> getAll() {
        return List.of();
    }
}
