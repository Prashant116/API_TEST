package com.example.API_TEST.repository.Service;

import com.example.API_TEST.model.History;
import com.example.API_TEST.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    HistoryRepository historyRepository;
    @Override
    public List<History> getHistory() {
        return historyRepository.findAll();
    }
}
