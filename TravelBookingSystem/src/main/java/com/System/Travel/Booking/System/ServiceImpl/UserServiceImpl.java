package com.System.Travel.Booking.System.ServiceImpl;

import com.System.Travel.Booking.System.Repository.UserRepository;
import com.System.Travel.Booking.System.Service.UserService;
import com.System.Travel.Booking.System.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create a new user
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Update an existing user
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);  // Save will update if the user exists
    }

    // Delete a user by ID
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
