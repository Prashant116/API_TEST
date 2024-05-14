package com.example.API_TEST.controller;

import com.example.API_TEST.model.BookRequest;
import com.example.API_TEST.repository.Service.BookRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookRequestService bookRequestService;

    //get booking request
    @GetMapping()
    public List<BookRequest> getBooking(){
        return bookRequestService.getAllRequest();
    }
}
