package com.stackroute.paymentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class PaymentDetails {
    @Id
    private String orderId;
    private String amount;
    private String currency;
    private String receipt;
    private String status;
    private String name;
    private String emailId;
    private String bookingId;
    private LocalDateTime localDateTime;

    public PaymentDetails() {
    }

    public PaymentDetails(String orderId, String amount, String currency, String receipt, String status, String name, String emailId, String bookingId, LocalDateTime localDateTime) {
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.receipt = receipt;
        this.status = status;
        this.name = name;
        this.emailId = emailId;
        this.bookingId = bookingId;
        this.localDateTime = localDateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "orderId='" + orderId + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", receipt='" + receipt + '\'' +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
