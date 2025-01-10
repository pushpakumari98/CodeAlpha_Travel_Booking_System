package com.System.Travel.Booking.System.Service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface PaymentService {
    Map<String, Object> createPaymentIntent(double amount);
}
