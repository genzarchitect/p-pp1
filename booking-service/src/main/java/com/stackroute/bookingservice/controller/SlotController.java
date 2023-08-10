package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.exceptions.*;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;
import com.stackroute.bookingservice.services.BookingService;
import com.stackroute.bookingservice.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {
    @Autowired
    public SlotService slotService;
    public ResponseEntity<?> responseEntity;

    @GetMapping("/slotList")
    public ResponseEntity<?> getAllSlots() {
        try {
            List<Slot> slots = slotService.getAllSlotFromRepo();
            responseEntity = new ResponseEntity<>(slots, HttpStatus.OK);
        } catch (EmptySlotList e) {
            responseEntity = new ResponseEntity<>("Slot List is Empty", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/addslot")
    public ResponseEntity<?> addSlot(@RequestBody Slot slot) throws SlotAlreadyFound{
        try{
            String slots= slotService.addAllSlotTobookingdb(slot);
            responseEntity=new ResponseEntity<>(slots,HttpStatus.CREATED);
        }catch(SlotAlreadyFound e){
            responseEntity=new ResponseEntity<>("Slot already found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/getslot/{slotId}")
    public ResponseEntity<?> getSlotI(@PathVariable("slotId") int slotId){
        try {
            Slot gslot = slotService.getSlotById(slotId);
            responseEntity = new ResponseEntity<>(gslot, HttpStatus.ACCEPTED);
        }catch (SlotIdNotFound e){
            responseEntity=new ResponseEntity<>("Slot not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/update/{slotId}")
    public ResponseEntity<?> updateSlot(@PathVariable("slotId") int slotId,@RequestBody Slot slot){
        try{
            Slot uslot = slotService.updateSlotById(slotId, slot);
            responseEntity=new ResponseEntity<>(uslot,HttpStatus.ACCEPTED);
        }catch(UpdateSlotNotFound e){
            responseEntity = new ResponseEntity<>("Please Select the slot",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}


