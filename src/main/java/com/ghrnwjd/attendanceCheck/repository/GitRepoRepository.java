package com.ghrnwjd.attendanceCheck.repository;

import com.ghrnwjd.attendanceCheck.model.GitRepo;
import com.ghrnwjd.attendanceCheck.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GitRepoRepository extends JpaRepository<GitRepo, Integer> {
<<<<<<< HEAD
=======

>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
    List<GitRepo> findAllByUser(User user);

}
