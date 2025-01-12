package com.example.API_TEST.repository;

import com.example.API_TEST.model.Author;
import com.example.API_TEST.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(Author author);
}
