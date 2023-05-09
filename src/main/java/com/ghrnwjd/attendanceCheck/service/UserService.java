package com.ghrnwjd.attendanceCheck.service;

import com.ghrnwjd.attendanceCheck.model.User;
import com.ghrnwjd.attendanceCheck.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User login(User user) {
        User user1 = userRepository.findByUserIdAndUserPassword(user.getUserId(), user.getUserPassword()).orElseGet(()-> {
            return null;
        });

        return user1;
    }

    @Transactional
    public void join(User user) {
        userRepository.save(user);
    }
}
