package com.ghrnwjd.attendanceCheck.repository;

import com.ghrnwjd.attendanceCheck.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserIdAndUserPassword(String userId, String userPassword);
}
