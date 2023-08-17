package com.stackroute.bookingservice.services;

import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.model.Slot;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    public List<Booking> getAllBookingFromRepo();

    public Booking addAllBookingToBookingdb(Booking booking);

    public Booking getBookingById(int bookingId);

    public Booking getBookingByPlayerEmail(String playerEmail);
    public Booking getBookingByOwnerEmail(String groundOwnerEmail);
    public Booking deleteBookingById(int bookingId);


}
