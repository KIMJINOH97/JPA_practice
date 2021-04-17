package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.BookRequestDto;
import com.relation.jpa_practice.controller.dto.BookResponseDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    public Long saveBook(BookRequestDto requestDto){
        Book book = requestDto.toEntity();
        return bookRepository.save(book).getId();
    }

    public List<BookResponseDto> findBooks(){
        List<Book> books = bookRepository.findAll();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book : books){
            bookResponseDtos.add(new BookResponseDto(book));
        }
        return bookResponseDtos;
    }

}
