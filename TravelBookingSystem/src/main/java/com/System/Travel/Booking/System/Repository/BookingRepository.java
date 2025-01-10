package com.System.Travel.Booking.System.Repository;


import com.System.Travel.Booking.System.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Retrieve bookings by user ID
    List<Booking> findByUserId(Long userId);

    // Retrieve bookings by status
    List<Booking> findByStatus(String status);
}
