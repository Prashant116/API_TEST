package com.example.API_TEST.controller;

import com.example.API_TEST.dto.TechnicianDto;
import com.example.API_TEST.model.*;
import com.example.API_TEST.repository.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("technician")
public class TechnicianController {

    @Autowired
    TechnicianService technicianService;
    @Autowired
    BookRequestService bookRequestService;

    @Autowired
    UpdateTechnicianService updateTechnician;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    RevenueService revenueService;

    @GetMapping("/{technicianId}")
    public TechnicianDto getTechnician(@PathVariable String technicianId){
        return technicianService.getTechnician(technicianId);
    }

    @GetMapping()
    public List<Technician> getAllTechnician(){
        return technicianService.getAllTechnicians();
    }

    @PostMapping("/booking")
    public String bookTechnician(@RequestBody BookRequest bookRequest){
        //function to book a technician
        return bookRequestService.bookTechnician(bookRequest);
    }

    @PutMapping("/update")
    public String updateTechnician(@RequestBody UpdateRequest updateRequest){
        return updateTechnician.updateTechnician(updateRequest);
    }

    @GetMapping("/viewSchedule")
    public List<Schedule> viewSchedule(){
        return scheduleService.viewSchedule();
    }

    @GetMapping("/revenue")
    public List<Revenue> getRevenue(){
        return revenueService.getRevenue();
    }

//3.2.4 Accept/Decline Booking (ABST4)
//    Method: POST
//    Description: Agro technicians can accept or decline booking requests.
//    Request Parameters:
//    id: ID of the booking request.
//            action: "accept" or "decline".

}