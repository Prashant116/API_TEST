package com.example.API_TEST.controller;

import com.example.API_TEST.model.History;
import com.example.API_TEST.repository.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("history")
public class HistoryController {
    @Autowired
    HistoryService historyService;


    @GetMapping()
    public List<History> getHistory(){
        return historyService.getHistory();
    }
}
