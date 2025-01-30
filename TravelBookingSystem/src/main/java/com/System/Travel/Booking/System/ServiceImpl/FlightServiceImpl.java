package com.System.Travel.Booking.System.ServiceImpl;

import com.System.Travel.Booking.System.Repository.FlightRepository;
import com.System.Travel.Booking.System.Service.FlightService;
import com.System.Travel.Booking.System.entity.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Retrieve all flights
    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Retrieve a flight by ID

    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null); // Return null if not found
    }

    // Create a new flight
    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Update an existing flight
    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);  // Save will update if the flight exists
    }

    // Delete a flight by ID
    @Override
    public String deleteFlightById(Long id) {
        if(flightRepository.existsById(id))
        {
            flightRepository.deleteById(id);
        }
        else{
            System.out.println(" Flight Id Not Found");
        }
        return "Flight deleted successfully";
    }



}
