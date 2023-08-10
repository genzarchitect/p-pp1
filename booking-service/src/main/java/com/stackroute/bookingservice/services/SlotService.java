package com.stackroute.bookingservice.services;

import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;

import java.util.List;

public interface SlotService {
    public List<Slot> getAllSlotFromRepo();
    public String addAllSlotTobookingdb(Slot slot);

    public Slot getSlotById(int slotId);
    public Slot updateSlotById(int slotId,Slot slot);
}
