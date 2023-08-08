package com.stackroute.paymentservice.controller;

import com.stackroute.paymentservice.model.RazorpayDetails;
import com.stackroute.paymentservice.repository.RazorpayDetailsRepository;
import com.stackroute.paymentservice.service.RazorpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    RazorpayService razorpayService;

    @Autowired
    RazorpayDetailsRepository razorpayDetailsRepository;

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody RazorpayDetails razorpayDetails) {
        String orderId = razorpayService.createOrder(razorpayDetails.getAmount());
        razorpayDetails.setId(orderId);
        razorpayDetailsRepository.save(razorpayDetails);
        return orderId;
    }
}
