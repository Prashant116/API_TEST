package com.example.API_TEST.controller;

import com.example.API_TEST.dto.AuthorDto;
import com.example.API_TEST.dto.BookDto;
import com.example.API_TEST.model.Author;
import com.example.API_TEST.model.Book;
import com.example.API_TEST.repository.Service.AuthorService;
import com.example.API_TEST.repository.Service.AuthorServiceImpl;
import com.example.API_TEST.repository.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class AuthorBookController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorBookController(AuthorService authorService, BookService bookService){
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @GetMapping("/{authorId}")
    public Author getAuthor(@PathVariable String authorId){
        return authorService.getAuthor(authorId);
    }
    @PostMapping("/author")
    public Author createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.createAuthor(authorDto);
    }

    @PostMapping()
    public Book createBook(@RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }

    @GetMapping("/bookBy/{authorId}")
    public List<Book> findByAuthor(@PathVariable String authorId){
        Author author = authorService.getAuthor(authorId);
        return bookService.getBooksByAuthor(author);
    }


    //Deleting an author delete the corresponding books as well
    @DeleteMapping("/author/{authorId}")
    public String deleteAuthor(@PathVariable String authorId){
        return authorService.deleteAuthor(authorId);
    }

    @GetMapping("/paged")
    public List<Author> findPagedAuthor(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size ,
                                        @RequestParam(defaultValue = "name") String sortBy,
                                        @RequestParam(defaultValue = "asc") String sortDir)
    {
        return authorService.getAuthorsPaged(page, size, sortBy, sortDir);
    }
}
