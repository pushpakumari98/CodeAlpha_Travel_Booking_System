package com.System.Travel.Booking.System.Controller;

import com.System.Travel.Booking.System.entity.Transportation;
import com.System.Travel.Booking.System.Service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transportations")
public class TransportationController {

    @Autowired
    private TransportationService transportationService;

    // Get all transportation services
    @GetMapping
    public List<Transportation> getAllTransportations() {
        return transportationService.getAllTransportations();
    }

    // Get transportation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transportation> getTransportationById(@PathVariable Long id) {
        Optional<Transportation> transportation = transportationService.getTransportationById(id);
        return transportation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new transportation service
    @PostMapping
    public ResponseEntity<Transportation> createTransportation(@RequestBody Transportation transportation) {
        Transportation createdTransportation = transportationService.createTransportation(transportation);
        return new ResponseEntity<>(createdTransportation, HttpStatus.CREATED);
    }

    // Update an existing transportation service
    @PutMapping("/{id}")
    public ResponseEntity<Transportation> updateTransportation(@PathVariable Long id, @RequestBody Transportation transportation) {
        Optional<Transportation> existingTransportation = transportationService.getTransportationById(id);
        if (existingTransportation.isPresent()) {
            transportation.setId(id);  // Ensure the ID of the transportation being updated remains the same
            Transportation updatedTransportation = transportationService.updateTransportation(transportation);
            return ResponseEntity.ok(updatedTransportation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a transportation service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportation(@PathVariable Long id) {
        if (transportationService.getTransportationById(id).isPresent()) {
            transportationService.deleteTransportation(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
