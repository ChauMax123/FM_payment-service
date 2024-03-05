package com.foodMarket.foodpaymentservice.Repository;

import com.foodMarket.foodpaymentservice.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodPaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByFoodOrderId(int foodOrderId);
}
