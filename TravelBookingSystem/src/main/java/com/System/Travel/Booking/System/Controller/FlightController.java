package com.System.Travel.Booking.System.Controller;

import com.System.Travel.Booking.System.Service.FlightService;
import com.System.Travel.Booking.System.entity.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Get all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Get flight by ID

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id); // Directly retrieve the flight
        if (flight != null) { // Check if the flight exists
            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Create a new flight
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    // Update an existing flight

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight existingFlight = flightService.getFlightById(id); // Directly retrieve the flight
        if (existingFlight != null) { // Check if the flight exists
            flight.setId(id); // Ensure the ID remains consistent
            Flight updatedFlight = flightService.updateFlight(flight);
            return ResponseEntity.ok(updatedFlight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Delete a flight

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id); // Retrieve the flight directly
        if (flight != null) { // Check if the flight exists
            flightService.deleteFlightById(id); // Delete the flight
            return ResponseEntity.noContent().build(); // Return 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found
        }
    }

}
