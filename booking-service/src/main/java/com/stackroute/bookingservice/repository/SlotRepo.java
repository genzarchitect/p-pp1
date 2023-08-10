package com.stackroute.bookingservice.repository;

import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepo extends MongoRepository<Slot,Integer> {
}
