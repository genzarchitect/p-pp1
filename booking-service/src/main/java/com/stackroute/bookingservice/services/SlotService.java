package com.stackroute.bookingservice.services;

import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;

import java.util.Date;
import java.util.List;

public interface SlotService {
    public List<Slot> getAllSlotFromRepo();
    public Slot addAllSlotTobookingdb(Slot slot);

    public Slot getSlotById(int slotId);
    public Slot getSlotByDate(String slotDate);
    public Slot updateSlotById(int slotId,Slot updatedslot);
}
