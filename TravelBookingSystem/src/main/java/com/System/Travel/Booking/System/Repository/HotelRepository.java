package com.System.Travel.Booking.System.Repository;

import com.System.Travel.Booking.System.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    // Search hotels by location
    List<Hotel> findByLocation(String location);

    // Search available hotels in a location
    List<Hotel> findByLocationAndStatus(String location, String status);
}
