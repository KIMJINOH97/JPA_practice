package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.BookRequestDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void findall(){
        //given
        String book1 = "book1";
        String book2 = "book2";
        String book3 = "book3";

        //when
        bookRepository.save(new Book(book1));
        bookRepository.save(new Book(book2));
        bookRepository.save(new Book(book3));


        //then
        List<Book> books = bookRepository.findAll();

        assertThat(books.size()).isEqualTo(3);
    }

}