package com.System.Travel.Booking.System.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // Generates getters, setters, and utility methods
@Entity
@Table(name = "transportation") // Maps the class to the "transportation" table
public class Transportation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long id;

    @Column(nullable = false)
    private String type; // Type of transportation (e.g., "CAB", "RENTAL_CAR", "SHUTTLE")

    @Column(nullable = false)
    private String location; // Location where the service is available

    @Column(nullable = false)
    private Double price; // Price for the transportation service

    @Column(nullable = false)
    private Integer availableUnits; // Number of units available for booking

    @Column(nullable = false)
    private String status; // Service status (e.g., "AVAILABLE", "BOOKED", "UNAVAILABLE")
}
