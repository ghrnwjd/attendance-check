package com.ghrnwjd.attendanceCheck.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNum;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPassword;

    @CreationTimestamp
    private Timestamp createdDate;

    @Column
    private String runTime;
}
