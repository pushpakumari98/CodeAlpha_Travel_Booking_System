package com.System.Travel.Booking.System.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data // Generates getters, setters, and other utility methods
@Entity
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String airline; // Name of the airline
    @Column(nullable = false)
    private String departure;  // Departure city/airport

    @Column(nullable = false)
    private String destination;  // Destination city/airport

    @Column(nullable = false)
    private LocalDateTime departureTime;  // Flight departure time

    @Column(nullable = false)
    private LocalDateTime arrivalTime;  // Flight arrival time
    @Column(nullable = false)
    private Double price;  // Ticket price

    @Column(nullable = false)
    private Integer availableSeats; // Seats available for booking

    @Column(nullable = false)
    private String status; // e.g., "ON_TIME", "CANCELLED", "DELAYED"


}
