package com.System.Travel.Booking.System.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingForm {
    private int id;

    @NotEmpty(message="name can't be empty")
    @NotBlank(message="name can't be blank")
    @Size(min=2,max=30,message="invalid name length")
    @Pattern(regexp="^[A-Za-z ]+$", message="Name must contain only alphabets and spaces")
    private String name;

    @NotEmpty(message="source can't be empty")
    @NotBlank(message="source can't be blank")
    @Size(min=2,max=100,message="invalid source length")
    private String from;

    @NotEmpty(message="email can't be empty")
    @NotBlank(message="email can't be blank")
    @Size(min=5,max=50,message="invalid email length")
    private String email;

    @NotEmpty(message="destination can't be empty")
    @NotBlank(message="destination can't be blank")
    @Size(min=2,max=100,message="invalid destination length")
    private String destination;

    @NotNull(message="time can't be empty")
    private LocalTime time;

    @NotNull(message="date can't be empty")
    private LocalDate date;

    @NotEmpty(message="comfort can't be empty")
    @Size(min=2,max=50,message="invalid comfort length")
    private String comfort;

    @Min(value=1,message="adult can be atleast 1")
    @Max(value=4,message="adult can be atmost 4")
    private  int adult;

    @Max(value=3,message="children can be atmost 3")
    private int children;

    @NotEmpty(message="message can't be empty")
    @NotBlank(message="message can't be blank")
    @Size(min=2,max=2000,message="invalid message length")
    private int message;

}
