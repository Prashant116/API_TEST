package com.example.API_TEST.repository.Service;

import com.example.API_TEST.dto.AuthorDto;
import com.example.API_TEST.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    Author createAuthor(AuthorDto authorDto);

    Author getAuthor(String authorId);

    String deleteAuthor(String authorId);

    //pagination loading
    List<Author> getAuthorsPaged(int page, int size, String sortBy, String sortDir);
}
