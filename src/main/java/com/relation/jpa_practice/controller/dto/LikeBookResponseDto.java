package com.relation.jpa_practice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.relation.jpa_practice.domain.LikeBook;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeBookResponseDto {
    @JsonProperty("member_name")
    private String memberName;

    @JsonProperty("book_name")
    private String bookName;

    public LikeBookResponseDto(LikeBook likeBook){
        this.memberName = likeBook.getMember().getName();
        this.bookName = likeBook.getBook().getName();
    }
}
