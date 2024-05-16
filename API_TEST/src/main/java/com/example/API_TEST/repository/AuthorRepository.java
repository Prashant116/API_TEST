package com.example.API_TEST.repository;

import com.example.API_TEST.model.Author;
import com.example.API_TEST.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> , PagingAndSortingRepository<Author, Long> {
}


