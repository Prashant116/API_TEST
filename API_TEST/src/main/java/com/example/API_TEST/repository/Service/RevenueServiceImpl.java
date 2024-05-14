package com.example.API_TEST.repository.Service;

import com.example.API_TEST.model.Revenue;
import com.example.API_TEST.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueServiceImpl implements RevenueService{

    @Autowired
    RevenueRepository revenueRepository;
    @Override
    public List<Revenue> getRevenue() {
        return revenueRepository.findAll();
    }
}
