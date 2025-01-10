package com.System.Travel.Booking.System.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data // Generates getters, setters, toString, equals, and hashCode
@Entity
@Table(name = "bookings") // Maps the class to the "bookings" table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long id;

    @Column(nullable = false)
    private Long userId; // ID of the user who made the booking

    @Column(nullable = false)
    private String serviceType; // Type of service (e.g., "FLIGHT", "HOTEL", "TRANSPORTATION")

    @Column(nullable = false)
    private Long serviceId; // ID of the booked service (e.g., flight ID, hotel ID)

    @Column(nullable = false)
    private LocalDateTime bookingDate; // Date and time when the booking was made

    @Column(nullable = false)
    private String status; // Booking status (e.g., "CONFIRMED", "CANCELLED", "PENDING")
}
