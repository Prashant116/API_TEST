package com.example.API_TEST.repository.Service;

import com.example.API_TEST.dto.AuthorDto;
import com.example.API_TEST.model.Author;
import com.example.API_TEST.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(AuthorDto authorDto) {
        Author author = Author.builder()
                        .name(authorDto.getName())
                .build();
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthor(String authorId) {
        return authorRepository.findById(Long.valueOf(authorId)).get();
    }

    @Override
    public String deleteAuthor(String authorId) {
        authorRepository.deleteById(Long.valueOf(authorId));
        return ("AuthorId "+authorId+" deleted");
    }

    @Override
    public List<Author> getAuthorsPaged(int page, int size, String sortBy, String sortDir) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
//        PageRequest pageRequest = PageRequest.of(page, size);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Author> authorPage = authorRepository.findAll(pageable);
        return authorPage.getContent();
    }
}
