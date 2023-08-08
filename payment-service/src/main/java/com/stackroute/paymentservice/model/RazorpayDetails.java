package com.stackroute.paymentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RazorpayDetails {
    @Id
    private String id;
    private String amount;
    private String email;
    private String name;

    public RazorpayDetails() {
    }

    public RazorpayDetails(String id, String amount, String email, String name) {
        this.id = id;
        this.amount = amount;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RazorpayDetails{" +
                "id='" + id + '\'' +
                ", amount='" + amount + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
