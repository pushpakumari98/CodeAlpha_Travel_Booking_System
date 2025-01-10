package com.System.Travel.Booking.System.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok for generating getters, setters, and other utility methods
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long id;

    @Column(nullable = false)
    private String name; // Hotel name

    @Column(nullable = false)
    private String location; // Hotel location (e.g., city, address)

    @Column(nullable = false)
    private Integer availableRooms; // Number of rooms available for booking

    @Column(nullable = false)
    private Double pricePerNight; // Price per night per room

    @Column(nullable = false)
    private String status; // e.g., "AVAILABLE", "BOOKED", "CLOSED"
}
