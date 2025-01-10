package com.System.Travel.Booking.System.Service;

import com.System.Travel.Booking.System.entity.Transportation;

import java.util.List;
import java.util.Optional;

public interface TransportationService {

    // Method to retrieve all transportation services
    List<Transportation> getAllTransportations();

    // Method to retrieve a transportation service by its ID
    Optional<Transportation> getTransportationById(Long id);

    // Method to create a new transportation service
    Transportation createTransportation(Transportation transportation);

    // Method to update an existing transportation service
    Transportation updateTransportation(Transportation transportation);

    // Method to delete a transportation service by its ID
    void deleteTransportation(Long id);
}
