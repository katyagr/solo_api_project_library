package com.example.library_data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findByAuthorSurname_authorExists() {
        fail();
    }

    @Test
    void findByAuthorSurname_authorDoesNotExist(){
        fail();
    }
}