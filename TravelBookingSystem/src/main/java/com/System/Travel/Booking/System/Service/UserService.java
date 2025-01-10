package com.System.Travel.Booking.System.Service;

import com.System.Travel.Booking.System.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // Method to retrieve all users
    List<User> getAllUsers();

    // Method to retrieve a user by its ID
    Optional<User> getUserById(Long id);

    // Method to create a new user
    User createUser(User user);

    // Method to update an existing user
    User updateUser(User user);

    // Method to delete a user by its ID
    void deleteUser(Long id);
}
