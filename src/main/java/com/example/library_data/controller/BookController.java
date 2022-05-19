package com.example.library_data.controller;

import com.example.library_data.model.Book;
import com.example.library_data.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok().body(books);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookRepository.save(book);
        return ResponseEntity.ok().body(newBook);
    }

    @PutMapping("books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id){
        Book update = bookRepository.findById(id).map(updatedBook -> {
            updatedBook.setTitle(book.getTitle());
            updatedBook.setGenre(book.getGenre());
            updatedBook.setAuthor(book.getAuthor());
            return bookRepository.save(updatedBook);})
                .orElseGet(() -> {return bookRepository.save(book);});
        return ResponseEntity.ok().body(update);

    }
}
