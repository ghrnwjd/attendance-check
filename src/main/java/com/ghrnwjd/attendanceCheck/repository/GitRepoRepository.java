package com.ghrnwjd.attendanceCheck.repository;

import com.ghrnwjd.attendanceCheck.model.GitRepo;
import com.ghrnwjd.attendanceCheck.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GitRepoRepository extends JpaRepository<GitRepo, Integer> {
    List<GitRepo> findAllByUser(User user);

}
