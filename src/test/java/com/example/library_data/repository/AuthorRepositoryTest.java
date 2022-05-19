package com.example.library_data.repository;

import com.example.library_data.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByAuthorSurname_authorExists() {
        //Given
        String surname = "Ragot";
        //When
        List<List<String>> booksByAuthor = authorRepository.findByAuthorSurname(surname);
        String titleOfFirstBook = booksByAuthor.get(0).get(0);
        Book firstBook = bookRepository.findAll().stream()
                .filter(book -> book.getTitle() == titleOfFirstBook).toList().get(0);
        //Then
        assertEquals(surname, firstBook.getAuthor().getLastName());
    }

    @Test
    void findByAuthorSurname_authorDoesNotExist(){
        //Given
        String notASurname = "not a name";
        //When
        List<List<String>> noBooks = authorRepository.findByAuthorSurname(notASurname);
        //Then
        assertEquals(0,noBooks.size());
    }
}