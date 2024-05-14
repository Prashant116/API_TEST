package com.example.API_TEST.repository.Service;

import com.example.API_TEST.dto.BookDto;
import com.example.API_TEST.model.Author;
import com.example.API_TEST.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(BookDto bookDto);

    List<Book> getBooksByAuthor(Author author);
}
