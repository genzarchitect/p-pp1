package com.stackroute.bookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import java.util.Date;
@Document
public class Booking {
    @Id
    private int bookingId;
    private Date bookingDateslot;
    private String groundId;
    private String playerEmail;
    private String groundOwnerEmail;
    private int slotId;
    private double pricePaid;
    //what will be in booking status;
    private String bookingStatus;
    private Date slotDate;

    public Booking() {
    }

    public Booking(int bookingId, Date bookingDateslot, String groundId, String playerEmail, String groundOwnerEmail, int slotId, double pricePaid, String bookingStatus, Date slotDate) {
        this.bookingId = bookingId;
        this.bookingDateslot = bookingDateslot;
        this.groundId = groundId;
        this.playerEmail = playerEmail;
        this.groundOwnerEmail = groundOwnerEmail;
        this.slotId = slotId;
        this.pricePaid = pricePaid;
        this.bookingStatus = bookingStatus;
        this.slotDate = slotDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDateslot() {
        return bookingDateslot;
    }

    public void setBookingDateslot(Date bookingDateslot) {
        this.bookingDateslot = bookingDateslot;
    }

    public String getGroundId() {
        return groundId;
    }

    public void setGroundId(String groundId) {
        this.groundId = groundId;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    public String getGroundOwnerEmail() {
        return groundOwnerEmail;
    }

    public void setGroundOwnerEmail(String groundOwnerEmail) {
        this.groundOwnerEmail = groundOwnerEmail;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDateslot=" + bookingDateslot +
                ", groundId='" + groundId + '\'' +
                ", playerEmail='" + playerEmail + '\'' +
                ", groundOwnerEmail='" + groundOwnerEmail + '\'' +
                ", slotId=" + slotId +
                ", pricePaid=" + pricePaid +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", slotDate=" + slotDate +
                '}';
    }
}
