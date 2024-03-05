package com.foodMarket.foodpaymentservice.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FOOD_PAYMENT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Payment {
    @Id
    @GeneratedValue
    private int paymentId;
    private String status;
    private String transactionId;
    private int foodOrderId;
    private double amount;

}
