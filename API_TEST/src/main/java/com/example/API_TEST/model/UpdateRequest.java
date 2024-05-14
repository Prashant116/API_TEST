package com.example.API_TEST.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "update_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int technicianId;
    private String address;
    private String certificate;
    private int chargePerHour;
    private String contact;
    private String catagory;
    private int workingHourFrom;
    private int workingHourTo;
}

//technician_id: Unique identifier for the technician.
//address: Technician's address.
//certificate: Technician certificate.
//charge_per_hour: Hourly charge.
//contact: Technician's contact information.
//category: Technician's category (e.g., JTA, veterinary doctor).
//working_hour_from: Start of working hours.
//working_hour_to: End of working hours.
