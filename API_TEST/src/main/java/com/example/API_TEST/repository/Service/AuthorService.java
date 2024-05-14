package com.example.API_TEST.repository.Service;

import com.example.API_TEST.dto.AuthorDto;
import com.example.API_TEST.model.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {
    Author createAuthor(AuthorDto authorDto);

    Author getAuthor(String authorId);

    String deleteAuthor(String authorId);
}
