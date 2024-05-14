package com.example.API_TEST.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name="history")
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String status;
    private LocalDateTime completionDate;
    private int technicianId;
    private String service;
}

//id: Primary key.
//title: Title of the booking.
//status: Status of the booking (e.g., "Completed", "In Progress").
//completion_date: Date and time when the booking was completed.
//technician_id: Technician involved in the booking.
//        service: Type of service provided.