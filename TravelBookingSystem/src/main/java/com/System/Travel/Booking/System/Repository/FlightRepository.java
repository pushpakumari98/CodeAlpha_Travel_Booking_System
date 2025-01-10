package com.System.Travel.Booking.System.Repository;

import com.System.Travel.Booking.System.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    // Search for flights by departure and destination
    List<Flight> findByDepartureAndDestination(String departure, String destination);

    // Search for flights by departure, destination, and date
    List<Flight> findByDepartureAndDestinationAndDepartureTimeBetween(
            String departure,
            String destination,
            LocalDateTime startDate,
            LocalDateTime endDate
    );
}
