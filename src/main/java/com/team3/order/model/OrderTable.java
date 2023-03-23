package com.team3.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderTable {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private Long postUserId;
    private Long purchaseUserId;
}