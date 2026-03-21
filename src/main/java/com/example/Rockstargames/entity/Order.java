package com.example.Rockstargames.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Data
public class Order {
    @Id
    private String order_id;
    private String game_id;
    private String price;
}
