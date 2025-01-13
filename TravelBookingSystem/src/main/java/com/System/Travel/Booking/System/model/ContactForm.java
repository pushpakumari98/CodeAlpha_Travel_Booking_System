package com.System.Travel.Booking.System.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

@Data

public class ContactForm {
    private int id;

    @NotEmpty(message="name cann't be empty")
    @Size(min=2,max=30,message="invalid name size")
//    @Pattern(
//            regexp = "^[A-Za-z ]+$",
//            message = "Name must contain only alphabets and spaces without digits or special characters.")
    private String name;   //@valid is used in UserController to validate the details of form


    @NotEmpty(message="email cann't be empty")
    @Size(min=5,max=50,message="invalid email size")
    private String email;

    @NotNull(message="phone no cann't be empty")
    @Min(value=1000000000,message="phone no must be at least 10 digits")
    @Max(value=9999999999L,message="phone no must be at least 10 digits")
//    @Pattern(
//            regexp = "^[0-9]+$",
//            message = "Phone number must contain only digits without spaces, alphabets, or special characters."
//    )
    private Long phone;


    @NotEmpty(message="message cann't be empty")
    @Size(min=2,max=500,message="invalid message size")
    private String message;
}
