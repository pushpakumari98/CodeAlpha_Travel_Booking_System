package com.System.Travel.Booking.System.ServiceImpl;

import com.System.Travel.Booking.System.Repository.HotelRepository;
import com.System.Travel.Booking.System.Service.HotelService;
import com.System.Travel.Booking.System.entity.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // Retrieve all hotels
    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Retrieve a hotel by ID
    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    // Create a new hotel
    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Update an existing hotel
    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);  // Save will update if the hotel exists
    }

    // Delete a hotel by ID
    @Override
    public String deleteHotelById(Long id) {
        if(hotelRepository.existsById(id))
        {
            hotelRepository.deleteById(id);
        }
        else{
            System.out.println(" Hotel Id Not Found");
        }
        return "Hotel deleted successfully";
    }
}
