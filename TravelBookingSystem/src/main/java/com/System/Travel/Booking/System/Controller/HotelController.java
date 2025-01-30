package com.System.Travel.Booking.System.Controller;

import com.System.Travel.Booking.System.Service.HotelService;
import com.System.Travel.Booking.System.entity.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Get all hotels
    @GetMapping
    public List<Hotel> getAllHotels() {

        return hotelService.getAllHotels();
    }

    // Get hotel by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        if (hotel != null) { // Check if the flight exists
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }

    // Update an existing hotel
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Hotel existingHotel = hotelService.getHotelById(id);

        if (existingHotel != null) { // Check if the flight exists
            hotel.setId(id); // Ensure the ID remains consistent
            Hotel updatedHotel = hotelService.updateHotel(hotel);
            return ResponseEntity.ok(updatedHotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a hotel
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id); // Retrieve the hotel directly
        if (hotel != null) { // Check if the hotel exists
            hotelService.deleteHotelById(id); // Delete the hotel
            return ResponseEntity.noContent().build(); // Return 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found
        }
    }
}
