package com.stackroute.paymentservice.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.OrderCreationFailedException;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RazorpayService {
    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

    public String createOrder(String amount) {
        try {
            RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecret);
            JSONObject options = new JSONObject();

            options.put("amount", amount);
            options.put("currency", "INR");

            String receiptId = UUID.randomUUID().toString();
            options.put("receipt", receiptId);
            Order order = razorpay.orders.create(options);

            return order.get("id");

        } catch (RazorpayException e) {
            throw new OrderCreationFailedException("Order Creation Failed");
        }
    }
}
