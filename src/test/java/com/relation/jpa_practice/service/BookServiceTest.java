package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.BookRequestDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookServiceTest {
    @Autowired private BookRepository bookRepository;
    @Autowired private BookService bookService;

    @Test // 책 저장
    public void save(){
        //given
        String b_name = "책";
        BookRequestDto bookRequestDto = new BookRequestDto();
        bookRequestDto.setName(b_name);

        //when
        Long id = bookService.saveBook(bookRequestDto);

        //then
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 ID 입니다."));
        assertThat(book.getName()).isEqualTo(b_name);
    }

}