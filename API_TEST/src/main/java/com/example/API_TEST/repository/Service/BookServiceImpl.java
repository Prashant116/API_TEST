package com.example.API_TEST.repository.Service;

import com.example.API_TEST.dto.BookDto;
import com.example.API_TEST.model.Author;
import com.example.API_TEST.model.Book;
import com.example.API_TEST.repository.AuthorRepository;
import com.example.API_TEST.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Book createBook(BookDto bookDto) {
        Author author = authorRepository.findById((long) bookDto.getId()).get();

        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(author)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }
}
