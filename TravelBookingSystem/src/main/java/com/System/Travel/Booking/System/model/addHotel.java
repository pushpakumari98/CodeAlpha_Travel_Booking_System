package com.System.Travel.Booking.System.model;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class addHotel {

    private Long id;

    @NotEmpty(message="Hotel name cann't be empty")
    @Size(min=30,max=100,message="invalid name size")
    private String name; // Hotel name

    @NotEmpty(message="hotel location name cann't be empty")
    private String location; // Hotel location (e.g., city, address)

    @NotNull(message="No of available rooms cann't be empty")
    private Integer availableRooms; // Number of rooms available for booking

    @NotNull(message="price cann't be empty")
    private Double pricePerNight; // Price per night per room

    @NotEmpty(message="status cann't be empty")
    @Size(min=30,max=100,message="invalid status size")
    private String status; // e.g., "AVAILABLE", "BOOKED", "CLOSED"


    
}
