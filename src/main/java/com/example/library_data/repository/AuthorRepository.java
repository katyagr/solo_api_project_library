package com.example.library_data.repository;

import com.example.library_data.model.Author;
import com.example.library_data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT book.title AS title, book.genre AS genre FROM author JOIN book ON (author.id = book.author_id) WHERE LOWER(author.last_name) = LOWER(:last_name)", nativeQuery = true)
    List<String> findByAuthorSurname(@Param("last_name") String lastName);
}
