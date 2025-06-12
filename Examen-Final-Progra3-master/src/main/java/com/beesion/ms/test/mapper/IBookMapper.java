package com.beesion.ms.test.mapper;

import com.beesion.ms.model.Book;
import com.beesion.ms.test.dto.BookDto;

public interface IBookMapper {
    Book toEntity(BookDto dto);
}
