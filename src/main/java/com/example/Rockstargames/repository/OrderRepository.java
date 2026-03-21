package com.example.Rockstargames.repository;

import com.example.Rockstargames.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
}
