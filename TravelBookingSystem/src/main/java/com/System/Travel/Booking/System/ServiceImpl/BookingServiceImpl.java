package com.System.Travel.Booking.System.ServiceImpl;

import com.System.Travel.Booking.System.Repository.BookingRepository;
import com.System.Travel.Booking.System.Service.BookingService;
import com.System.Travel.Booking.System.entity.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Retrieve all bookings
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Retrieve a booking by ID
    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // Create a new booking
    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Update an existing booking
    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);  // Save will update if the booking exists
    }

    // Delete a booking by ID
    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
