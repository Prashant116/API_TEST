package com.example.API_TEST.repository.Service;

import com.example.API_TEST.model.UpdateRequest;
import com.example.API_TEST.repository.UpdateTechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTechnicianServiceImpl implements UpdateTechnicianService{

    @Autowired
    UpdateTechnicianRepository updateTechnicianRepository;
    @Override
    public String updateTechnician(UpdateRequest updateRequest) {
        updateTechnicianRepository.save(updateRequest);
        return "Technician information updated successfully.";
    }
}
