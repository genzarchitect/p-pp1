package com.stackroute.bookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.sql.Time;
import java.util.Date;

@Document
public class Slot {

    @Id
    private int slotId;
    private Date slotDate;
    private String slotStartTiming;
    private String slotEndTiming;
    private String status;
    private int numberOfPlayers;

    public Slot() {
    }

    public Slot(int slotId, Date slotDate, String slotStartTiming, String slotEndTiming, String status, int numberOfPlayers) {
        this.slotId = slotId;
        this.slotDate = slotDate;
        this.slotStartTiming = slotStartTiming;
        this.slotEndTiming = slotEndTiming;
        this.status = status;
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

    public String getSlotStartTiming() {
        return slotStartTiming;
    }

    public void setSlotStartTiming(String slotStartTiming) {
        this.slotStartTiming = slotStartTiming;
    }

    public String getSlotEndTiming() {
        return slotEndTiming;
    }

    public void setSlotEndTiming(String slotEndTiming) {
        this.slotEndTiming = slotEndTiming;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", slotDate=" + slotDate +
                ", slotStartTiming=" + slotStartTiming +
                ", slotEndTiming=" + slotEndTiming +
                ", status='" + status + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                '}';
    }
}
