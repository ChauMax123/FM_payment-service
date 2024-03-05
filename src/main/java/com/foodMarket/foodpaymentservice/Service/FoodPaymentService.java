package com.foodMarket.foodpaymentservice.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodMarket.foodpaymentservice.Entity.Payment;
import com.foodMarket.foodpaymentservice.Repository.FoodPaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class FoodPaymentService {
    @Autowired
    private FoodPaymentRepository foodPaymentRepository;
    private Logger log= LoggerFactory.getLogger(FoodPaymentService.class);

    public Payment billPayment(Payment foodpayment) throws JsonProcessingException {
        foodpayment.setStatus(paymentProcessing());
        foodpayment.setTransactionId(UUID.randomUUID().toString());
        log.info("PaymentService request : {}", new ObjectMapper().writeValueAsString(foodpayment));
        return foodPaymentRepository.save(foodpayment);
    }

    public String paymentProcessing(){
        //API should be 3rd party Payment gateway(PAYPAL/PAYTM/.....)

        return new Random().nextBoolean()?"success" : "false";
    }

    public Payment findPaymentHistoryByOrderId(int foodOrderId) throws JsonProcessingException {
        Payment payment = foodPaymentRepository.findByFoodOrderId(foodOrderId);
        log.info("PaymentService findPaymentHistoryByOrderId : {}", new ObjectMapper().writeValueAsString(payment));
        return payment;
    }

}
