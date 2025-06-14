package com.beesion.ms.mapper;

import com.beesion.ms.domain.Book;
import com.beesion.ms.dto.BookDto;
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