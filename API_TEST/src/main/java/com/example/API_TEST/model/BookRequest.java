package com.example.API_TEST.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="book_technician")
public class BookRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private String service;
    private int sellerId;
    private String sellerLocation;
    private String technicianId;
}
//id: Primary key (Auto increment or Varchar).
//title: Appointment title (Varchar).
//service: Description of the service required (Varchar).
//seller_id: Foreign key referencing the seller's token.
//seller_location: Seller's location (Varchar).
//technician_id: Technician's ID (Varchar).