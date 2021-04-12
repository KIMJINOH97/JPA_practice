package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.BookRequestDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookPostController {
    private final BookService bookService;

    @PostMapping("/api/post/book")
    public Long saveBook(@RequestBody BookRequestDto requestDto){
        return bookService.saveBook(requestDto);
    }

    @GetMapping("/api/post/books")
    public List<Book> findBooks(){
        return bookService.findBooks();
    }

}
