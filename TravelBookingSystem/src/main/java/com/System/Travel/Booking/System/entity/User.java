package com.System.Travel.Booking.System.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Non-null constraint
    private String name;

    @Column(nullable = false, unique = true) // Unique constraint for email
    private String email;


    @Column(nullable = false) // Password cannot be null
    private String password;

    @Column(nullable = false) // Role cannot be null
    private String role; //ADMIN or USER

}
