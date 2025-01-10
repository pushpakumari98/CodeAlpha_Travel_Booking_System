package com.System.Travel.Booking.System.ServiceImpl;

import com.System.Travel.Booking.System.Repository.TransportationRepository;
import com.System.Travel.Booking.System.Service.TransportationService;
import com.System.Travel.Booking.System.entity.Transportation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportationServiceImpl implements TransportationService {

    @Autowired
    private TransportationRepository transportationRepository;

    // Retrieve all transportation services
    @Override
    public List<Transportation> getAllTransportations() {
        return transportationRepository.findAll();
    }

    // Retrieve a transportation service by ID
    @Override
    public Optional<Transportation> getTransportationById(Long id) {
        return transportationRepository.findById(id);
    }

    // Create a new transportation service
    @Override
    public Transportation createTransportation(Transportation transportation) {
        return transportationRepository.save(transportation);
    }

    // Update an existing transportation service
    @Override
    public Transportation updateTransportation(Transportation transportation) {
        return transportationRepository.save(transportation);  // Save will update if the service exists
    }

    // Delete a transportation service by ID
    @Override
    public void deleteTransportation(Long id) {
        transportationRepository.deleteById(id);
    }
}
