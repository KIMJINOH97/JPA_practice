package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.LikeBookResponseDto;
import com.relation.jpa_practice.domain.Book;
import com.relation.jpa_practice.domain.LikeBook;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.repository.BookRepository;
import com.relation.jpa_practice.repository.LikeRepository;
import com.relation.jpa_practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;
    private final BookRepository bookRepository;

    public Long saveLike(Long m_id, Long b_id){
        Member member = memberRepository.findById(m_id).orElseThrow(()-> new IllegalArgumentException(""));
        Book book = bookRepository.findById(b_id).orElseThrow(() -> new IllegalArgumentException(""));
        LikeBook likeBook = new LikeBook();
        likeBook.setMember(member);
        likeBook.setBook(book);
        return likeRepository.save(likeBook).getId();
    }

    public List<LikeBookResponseDto> findLikes(){
        List<LikeBook> likes = likeRepository.findAll();
        List<LikeBookResponseDto> responseDtos = new ArrayList<>();
        for (LikeBook like  : likes){
            responseDtos.add(new LikeBookResponseDto(like));
        }
        return responseDtos;
    }


}
