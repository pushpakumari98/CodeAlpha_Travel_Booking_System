package com.System.Travel.Booking.System.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddFlight {

    private Long id;

    private String airline; // Name of the airline

    private String departure;  // Departure city/airport


    private String destination;  // Destination city/airport


    private LocalDateTime departureTime;  // Flight departure time


    private LocalDateTime arrivalTime;  // Flight arrival time

    private Double price;  // Ticket price


    private Integer availableSeats; // Seats available for booking


    private String status; // e.g., "ON_TIME", "CANCELLED", "DELAYED"

}
