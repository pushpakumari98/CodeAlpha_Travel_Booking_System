package com.System.Travel.Booking.System.Service;

import com.System.Travel.Booking.System.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface HotelService {

    // Method to retrieve all hotels
    List<Hotel> getAllHotels();

    // Method to retrieve a hotel by its ID
    public Hotel getHotelById(Long id);

    // Method to create a new hotel
    Hotel createHotel(Hotel hotel);

    // Method to update an existing hotel
    Hotel updateHotel(Hotel hotel);

    // Method to delete a hotel by its ID
    String deleteHotelById(Long id);
}
