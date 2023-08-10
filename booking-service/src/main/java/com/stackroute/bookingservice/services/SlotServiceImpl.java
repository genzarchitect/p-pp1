package com.stackroute.bookingservice.services;

import com.stackroute.bookingservice.exceptions.*;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;
import com.stackroute.bookingservice.repository.BookingRepo;
import com.stackroute.bookingservice.repository.SlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService{
    @Autowired
    public SlotRepo slotRepo;

    @Override
    public List<Slot> getAllSlotFromRepo() {
        List<Slot> slots = slotRepo.findAll();
        if (slots.size() > 0) {
            return slots;
        }
        throw new EmptySlotList("Slot List is Empty");

    }

    @Override
    public String addAllSlotTobookingdb(Slot slot) {
        boolean slots = slotRepo.save(slot) != null;
        if (slots) {
            return "Slot is added succesfully";
        }
        throw new SlotAlreadyFound("Slot Already Found");

    }

    @Override
    public Slot getSlotById(int slotId) {
        Optional<Slot> slots = slotRepo.findById(slotId);
        if (slots.isPresent()) {
            Slot slot = slots.get();
            slotRepo.findById(slotId);
            return slot;
        }

        throw new BookingIdNotFound("Booking to be deleted not Found");
    }

    @Override
    public Slot updateSlotById(int slotId, Slot updatedslot) {
        Optional<Slot> existingslotopt = slotRepo.findById(slotId);

        if (existingslotopt.isPresent()) {
            Slot existingslots = existingslotopt.get();
            existingslots.setSlotId(updatedslot.getSlotId());
            existingslots.setStatus(updatedslot.getStatus());
            existingslots.setSlotDate(updatedslot.getSlotDate());
            existingslots.setSlotStartTiming(updatedslot.getSlotStartTiming());
            existingslots.setSlotEndTiming(updatedslot.getSlotEndTiming());
            existingslots.setNumberOfPlayers(updatedslot.getNumberOfPlayers());

            slotRepo.save(existingslots);
            return existingslots;
        }
        throw new UpdateSlotNotFound("Please select the slot to update");
    }
}

