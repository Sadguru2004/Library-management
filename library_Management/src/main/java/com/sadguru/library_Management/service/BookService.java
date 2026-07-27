package com.sadguru.library_Management.service;

import com.sadguru.library_Management.dto.request.BookRequest;
import com.sadguru.library_Management.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse addBook(BookRequest request);

    List<BookResponse> getAllBooks();

    BookResponse updateBook(Long id,BookRequest request);

    BookResponse getBookById(Long id);

    void delete(Long id);
}
