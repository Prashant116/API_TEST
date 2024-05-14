package com.example.API_TEST.repository.Service;

import com.example.API_TEST.dto.TechnicianDto;
import com.example.API_TEST.model.Technician;

import java.util.List;

public interface TechnicianService {
    TechnicianDto getTechnician(String id);

    List<Technician> getAllTechnicians();


}