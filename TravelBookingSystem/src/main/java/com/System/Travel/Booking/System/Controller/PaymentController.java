package com.System.Travel.Booking.System.Controller;

import com.System.Travel.Booking.System.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public Map<String, Object> createPaymentIntent(@RequestParam double amount) {
        return paymentService.createPaymentIntent(amount);
    }
}
