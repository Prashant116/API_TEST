package com.example.API_TEST.repository.Service;

import com.example.API_TEST.dto.TechnicianDto;
import com.example.API_TEST.model.Technician;
import com.example.API_TEST.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianServiceImpl implements TechnicianService {

    @Autowired
    TechnicianRepository technicianRepository;
    @Override
    public TechnicianDto getTechnician(String id) {
        Technician technician = technicianRepository.findById(Integer.valueOf(id)).get();
        return TechnicianDto.builder()
                .changePerHour(technician.getChangePerHour())
                .contact(technician.getContact())
                .name(technician.getName())
                .imageName(technician.getImageName())
                .location(technician.getLocation())
                .ratings(technician.getRatings())
                .build();
    }

    @Override
    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }
}
