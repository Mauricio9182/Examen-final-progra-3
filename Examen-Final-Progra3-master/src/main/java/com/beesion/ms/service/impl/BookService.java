package com.beesion.ms.service.impl;

import com.beesion.ms.domain.Book;
import com.beesion.ms.dto.BookDto;
import com.beesion.ms.mapper.BookMapper;
import com.beesion.ms.repository.BookRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class BookService {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookRepository.listAll();
    }

    public void createBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        bookRepository.persist(book);
    }

    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(bookRepository.findById(id));
    }

    public List<Book> getBooksByPageCountGreaterThan(Long pages) {
        return bookRepository.find("numPages > ?1", pages).list();
    }
}