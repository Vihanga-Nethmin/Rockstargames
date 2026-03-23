package com.example.Rockstargames.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(OrderDetailPK.class) // Composite Key එක මෙතනට ඕනේ
public class OrderDetail {
    @Id
    private String order_id;
    @Id
    private String customer_id; // PK එකට අදාළ field එක

    private String order_date;
    private String total_amount;
}