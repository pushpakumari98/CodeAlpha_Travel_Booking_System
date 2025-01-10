package com.System.Travel.Booking.System.Service;

import com.System.Travel.Booking.System.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    // Method to retrieve all bookings
    List<Booking> getAllBookings();

    // Method to retrieve a booking by its ID
    Optional<Booking> getBookingById(Long id);

    // Method to create a new booking
    Booking createBooking(Booking booking);

    // Method to update an existing booking
    Booking updateBooking(Booking booking);

    // Method to delete a booking by its ID
    void deleteBooking(Long id);
}
