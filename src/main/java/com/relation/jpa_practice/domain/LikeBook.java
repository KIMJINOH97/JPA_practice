package com.relation.jpa_practice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class LikeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "book_id")
    private Book book;

    public void setMember(Member member) {
        this.member = member;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
