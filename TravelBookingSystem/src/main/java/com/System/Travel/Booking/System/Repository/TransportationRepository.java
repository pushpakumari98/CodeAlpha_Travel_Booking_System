package com.System.Travel.Booking.System.Repository;

import com.System.Travel.Booking.System.entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long> {

    // Search for transportation by type and location
    List<Transportation> findByTypeAndLocation(String type, String location);

    // Search for available transportation in a location
    List<Transportation> findByLocationAndStatus(String location, String status);
}
