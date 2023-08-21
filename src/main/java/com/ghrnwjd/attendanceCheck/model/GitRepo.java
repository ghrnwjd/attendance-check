package com.ghrnwjd.attendanceCheck.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GitRepo {
<<<<<<< HEAD
=======

>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    @Column
    private String repoName;

}
