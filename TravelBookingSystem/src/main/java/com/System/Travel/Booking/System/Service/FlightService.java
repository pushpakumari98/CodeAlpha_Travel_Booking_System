package com.System.Travel.Booking.System.Service;

import com.System.Travel.Booking.System.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface FlightService {

    // Method to retrieve all flights
    List<Flight> getAllFlights();

    // Method to retrieve a flight by its ID
    Optional<Flight> getFlightById(Long id);

    // Method to create a new flight
    Flight createFlight(Flight flight);

    // Method to update an existing flight
    Flight updateFlight(Flight flight);

    // Method to delete a flight by its ID
    void deleteFlight(Long id);
}
