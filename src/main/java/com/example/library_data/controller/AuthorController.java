package com.example.library_data.controller;

import com.example.library_data.model.Author;
import com.example.library_data.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    public final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        return ResponseEntity.ok().body(authors);
    }
}
