package com.ghrnwjd.attendanceCheck.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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

    @Column
    private String gitId;

    @CreationTimestamp
    private Timestamp createdDate;

    @ColumnDefault("0")
    private int cumulativeAttendance;


}
