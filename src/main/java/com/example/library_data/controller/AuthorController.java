package com.example.library_data.controller;

import com.example.library_data.model.Author;
import com.example.library_data.model.Book;
import com.example.library_data.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/authors")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author newAuthor = authorRepository.save(author);
        return ResponseEntity.ok().body(newAuthor);
    }

    @PutMapping("authors/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable Long id){
        Author update = authorRepository.findById(id).map(updatedAuthor -> {
                    updatedAuthor.setFirstName(author.getFirstName());
                    updatedAuthor.setLastName(author.getLastName());
                    return authorRepository.save(updatedAuthor);})
                .orElseGet(() -> {return authorRepository.save(author);});
        return ResponseEntity.ok().body(update);

    }

    @DeleteMapping("authors/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        authorRepository.getById(id);
        return ResponseEntity.ok("Author with id " + id + " has been removed from database.");
    }
}
