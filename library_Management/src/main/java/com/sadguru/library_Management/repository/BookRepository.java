package com.sadguru.library_Management.repository;

import com.sadguru.library_Management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
