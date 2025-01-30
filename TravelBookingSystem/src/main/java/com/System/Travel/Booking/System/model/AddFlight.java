package com.System.Travel.Booking.System.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddFlight {

    private Long id;


    @NotEmpty(message="airline name cann't be empty")
    @Size(min=30,max=100,message="invalid name size")
    private String airline; // Name of the airline


    @NotEmpty(message="Departure city/airport  cann't be empty")
    @Size(min=50,max=100,message="invalid name size")
    private String departure;  // Departure city/airport


    @NotEmpty(message="Destination city/airport  cann't be empty")
    @Size(min=50,max=100,message="invalid name size")
    private String destination;  // Destination city/airport



    @NotNull(message="time  cann't be empty")

    private LocalDateTime departureTime;  // Flight departure time


    @NotNull(message="time  cann't be empty")
    private LocalDateTime arrivalTime;  // Flight arrival time

    @NotNull(message="price   cann't be empty")
    private Double price;  // Ticket price


    @NotNull(message="seats no  cann't be empty")
    private Integer availableSeats; // Seats available for booking


    @NotEmpty(message="status  cann't be empty")
    private String status; // e.g., "ON_TIME", "CANCELLED", "DELAYED"

}
