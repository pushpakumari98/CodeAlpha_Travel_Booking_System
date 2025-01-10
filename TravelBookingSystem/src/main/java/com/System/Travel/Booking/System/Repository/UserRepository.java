package com.System.Travel.Booking.System.Repository;

import com.System.Travel.Booking.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // Custom query methods can be added here
    User findByEmail(String email);
}
