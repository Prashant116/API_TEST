package com.example.API_TEST.repository.Service;

import com.example.API_TEST.model.BookRequest;

import java.util.List;

public interface BookRequestService {
    String bookTechnician(BookRequest bookRequest);

    List<BookRequest> getAllRequest();
}
