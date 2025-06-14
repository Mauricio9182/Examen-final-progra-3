package com.beesion.ms.mapper;

import com.beesion.ms.domain.Book;
import com.beesion.ms.dto.BookDto;

public interface IBookMapper {
    Book toEntity(BookDto dto);
}
