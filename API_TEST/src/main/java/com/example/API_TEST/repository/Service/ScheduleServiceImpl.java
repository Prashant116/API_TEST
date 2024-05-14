package com.example.API_TEST.repository.Service;

import com.example.API_TEST.model.Schedule;
import com.example.API_TEST.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;


    @Override
    public List<Schedule> viewSchedule() {
        return scheduleRepository.findAll();
    }
}
