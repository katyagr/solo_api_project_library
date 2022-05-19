package com.example.library_data.repository;

import com.example.library_data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE LOWER(genre) LIKE LOWER(CONCAT('%',:genre,'%'))", nativeQuery = true)
    List<Book> findByGenre(@Param("genre") String genre);


}
