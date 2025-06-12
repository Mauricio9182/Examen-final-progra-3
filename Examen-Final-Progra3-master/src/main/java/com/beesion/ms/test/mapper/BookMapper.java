package com.beesion.ms.test.mapper;

import com.beesion.ms.model.Book;
import com.beesion.ms.test.dto.BookDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookMapper {
    public Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setNumPages(dto.getNumPages());
        book.setPubDate(dto.getPubDate());
        book.setDescription(dto.getDescription());
        book.setTitle(dto.getTitle());
        return book;
    }
}