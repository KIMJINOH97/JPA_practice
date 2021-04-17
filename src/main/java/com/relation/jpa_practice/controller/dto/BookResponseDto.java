package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BookResponseDto {
    private Long id;
    private String name;

    public BookResponseDto(Book book){
        this.id = book.getId();
        this.name = book.getName();
    }
}
