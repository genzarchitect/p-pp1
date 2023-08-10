package com.stackroute.bookingservice.services;

import com.stackroute.bookingservice.exceptions.*;
import com.stackroute.bookingservice.model.Booking;
import com.stackroute.bookingservice.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    public BookingRepo bookingRepo;

    @Override
    public List<Booking> getAllBookingFromRepo() {

        List<Booking> bookings = bookingRepo.findAll();
        if (bookings.size() > 0) {
            return bookings;
        }
        throw new EmptyBookingList("Booking List is Empty");

    }

    @Override
    public String addAllBookingToBookingdb(Booking booking) {
        boolean bookings = bookingRepo.save(booking) != null;
        if (bookings) {
            return "Booking is added Succesfully";
        }
        throw new BookingAlreadyFound("Booking Already Found");
    }


    @Override
    public Booking getBookingById(int bookingId) {
        Optional<Booking> bookings = bookingRepo.findById(bookingId);
        if (bookings.isPresent()) {
            Booking booking = bookings.get();
            bookingRepo.findById(bookingId);
            return booking;
        }

        throw new BookingIdNotFound("Booking to be deleted not Found");
    }



    @Override
    public Booking getBookingByPlayerEmail(String playerEmail) {
        Optional<Booking> bookings = bookingRepo.findByEmail(playerEmail);
        if (bookings.isPresent()) {
            Booking booking = bookings.get();
            bookingRepo.findByEmail(playerEmail);
            return booking;
        }
        throw new BookingPlayerEmailNotFound("Booking  not Found");


    }

    @Override
    public Booking getBookingByOwnerEmail(String groundOwnerEmail) {
        Optional<Booking> bookings = bookingRepo.findByOEmail(groundOwnerEmail);
        if (bookings.isPresent()) {
            Booking booking = bookings.get();
            bookingRepo.findByOEmail(groundOwnerEmail);

            return booking;
        }
        throw new BookingOwnerEmailNotFound("Booking to be deleted not Found");
    }
    @Override
    public Booking deleteBookingById(int bookingId) {
        Optional<Booking> bookings = bookingRepo.findById(bookingId);
        if (bookings.isPresent()) {
            Booking booking = bookings.get();
            bookingRepo.delete(booking);
            return booking;
        }

        throw new DeleteBookingIdNotFound("Booking to be deleted not Found");
    }

}

