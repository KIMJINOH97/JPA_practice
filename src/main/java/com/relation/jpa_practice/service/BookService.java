package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.BookRequestDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    public Long saveBook(BookRequestDto requestDto){
        Book book = requestDto.toEntity();
        return bookRepository.save(book).getId();
    }

}
