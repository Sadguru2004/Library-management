package com.sadguru.library_Management.service.impl;

import com.sadguru.library_Management.dto.request.BookRequest;
import com.sadguru.library_Management.dto.response.BookResponse;
import com.sadguru.library_Management.entity.Book;
import com.sadguru.library_Management.exception.ResourceNotFoundException;
import com.sadguru.library_Management.repository.BookRepository;
import com.sadguru.library_Management.service.BookService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public BookResponse addBook(BookRequest request) {
        Book book = Book.builder()
                .BookName(request.getBookName())
                .author(request.getAuthor())
                .created_at(LocalDateTime.now())
                .build();

        Book savedBook = repository.save(book);
        return mapToResponse(savedBook);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No book found with this id: "+ id));

        book.setBookName(request.getBookName());
        book.setAuthor(request.getAuthor());

        Book updatedBook = repository.save(book);
        return mapToResponse(updatedBook);
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No book found with this id: "+ id));
        return mapToResponse(book);
    }

    @Override
    public void delete(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No book found with this id: "+ id));

        repository.delete(book);

    }

    public BookResponse mapToResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .BookName(book.getBookName())
                .author(book.getAuthor())
                .created_at(book.getCreated_at())
                .build();
    }
}
