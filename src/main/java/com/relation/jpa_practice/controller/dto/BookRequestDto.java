package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    public String name;

    public Book toEntity(){
        return new Book(name);
    }
}
