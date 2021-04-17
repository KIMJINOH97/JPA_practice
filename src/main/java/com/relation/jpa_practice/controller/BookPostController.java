package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.ApiForm;
import com.relation.jpa_practice.controller.dto.BookRequestDto;
import com.relation.jpa_practice.controller.dto.BookResponseDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.relation.jpa_practice.controller.dto.ApiForm.succed;

@RequiredArgsConstructor
@RestController
public class BookPostController {
    private final BookService bookService;

    @PostMapping("/api/post/book")
    public ApiForm<Long> saveBook(@RequestBody BookRequestDto requestDto){
        return succed(bookService.saveBook(requestDto));
    }

    @GetMapping("/api/post/books")
    public ApiForm<List<BookResponseDto>> findBooks(){
        return succed(bookService.findBooks());
    }
}
