package com.example.API_TEST.controller;

import com.example.API_TEST.dto.AuthorDto;
import com.example.API_TEST.dto.BookDto;
import com.example.API_TEST.model.Author;
import com.example.API_TEST.model.Book;
import com.example.API_TEST.repository.Service.AuthorService;
import com.example.API_TEST.repository.Service.AuthorServiceImpl;
import com.example.API_TEST.repository.Service.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

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
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDto authorDto){
        HttpHeaders header = new HttpHeaders();
        header.add("Message", "Author Created");
        return new ResponseEntity<>(authorService.createAuthor(authorDto), header, HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto){

//        try{Book book =  bookService.createBook(bookDto);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-header", "Created book successfully");
//            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(book);
//        }
//        catch(Exception e){
//            System.out.println("Error "+e.getMessage());
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author Not Found");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
        try{
            Book book = bookService.createBook(bookDto);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(new Book(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/bookBy/{authorId}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable String authorId){
        Author author = authorService.getAuthor(authorId);
        return new ResponseEntity<>(bookService.getBooksByAuthor(author), HttpStatus.OK);
    }


    //Deleting an author delete the corresponding books as well
    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable String authorId){
        return new ResponseEntity<>(authorService.deleteAuthor(authorId), HttpStatus.OK);
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
