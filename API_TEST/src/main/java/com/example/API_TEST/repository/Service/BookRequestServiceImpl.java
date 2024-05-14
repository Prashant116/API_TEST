package com.example.API_TEST.repository.Service;

import com.example.API_TEST.model.BookRequest;
import com.example.API_TEST.repository.BookRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRequestServiceImpl implements BookRequestService{

    @Autowired
    BookRequestRepository bookRequestRepository;
    @Override
    public String bookTechnician(BookRequest bookRequest) {
        bookRequestRepository.save(bookRequest);
        return "Booking completed successfully.";
    }

    @Override
    public List<BookRequest> getAllRequest() {
        return bookRequestRepository.findAll();
    }
}
