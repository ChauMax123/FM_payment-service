package com.foodMarket.foodpaymentservice.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.foodMarket.foodpaymentservice.Entity.Payment;
import com.foodMarket.foodpaymentservice.Service.FoodPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payment")

public class FoodPaymentController {
    @Autowired
    private FoodPaymentService foodPaymentService ;

    @PostMapping("/foodPayment")

    public Payment completePayment(@RequestBody Payment payment) throws JsonProcessingException {

        return foodPaymentService.billPayment(payment);
    }
    @GetMapping("/{foodOrderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int foodOrderId) throws JsonProcessingException {
        return foodPaymentService.findPaymentHistoryByOrderId(foodOrderId);
    }
}
