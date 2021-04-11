package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.domain.LikeBook;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.BookRepository;
import com.relation.jpa_practice.repository.LikeRepository;
import com.relation.jpa_practice.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LikeBookServiceTest {
    @Autowired private LikeService likeService;
    @Autowired private MemberService memberService;
    @Autowired private LikeRepository likeRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private BookRepository bookRepository;

    @Test
    public void saveLike(){
        //given
        String t_name = "team1";
        String m_name = "member1";
        String b_name = "book1";
        int age = 24;

        Team team = new Team(t_name);
        MemberRequestDto requestDto = new MemberRequestDto(m_name, age);
        Book book = new Book(b_name);

        //when
        teamRepository.save(team);
        memberService.save(1L, requestDto);
        bookRepository.save(book);
        likeService.saveLike(1L, 1L);

        LikeBook likeBook = likeRepository.findById(1L).orElseThrow(()->
                new IllegalArgumentException("no id"));

        //then
        assertThat(likeBook.getBook().getName()).isEqualTo(b_name);
    }

}