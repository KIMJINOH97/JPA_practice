package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikePostController {
    private final LikeService likeService;

    @PostMapping("/api/post/{member_id}/like/{book_id}")
    public Long saveLike(@PathVariable(name = "member_id") Long m_id, @PathVariable(name = "book_id") Long b_id){
        return likeService.saveLike(m_id, b_id);
    }
}
