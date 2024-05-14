package com.example.API_TEST.repository;

import com.example.API_TEST.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRequestRepository extends JpaRepository<BookRequest, Integer> {
}
