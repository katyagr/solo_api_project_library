package com.example.library_data.repository;

import com.example.library_data.model.Book;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByGenre_genreExists() {
        //Given
        String genre = "comedy";
        //When
        List<Book> booksOfGenre = bookRepository.findByGenre(genre);
        //Then
        assertTrue(StringUtils.containsIgnoreCase(booksOfGenre.get(0).getGenre(), genre));
    }

    @Test
    void findByGenre_genreDoesNotExist(){
        //Given
        String notAGenre = "upside down";
        //When
        List<Book> noBooks = bookRepository.findByGenre(notAGenre);
        //Then
        assertEquals(0, noBooks.size());
    }
}