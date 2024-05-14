package com.example.API_TEST.repository;

import com.example.API_TEST.model.UpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateTechnicianRepository extends JpaRepository<UpdateRequest, Integer> {
}
