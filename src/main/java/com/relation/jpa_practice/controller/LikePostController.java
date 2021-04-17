package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.ApiForm;
import com.relation.jpa_practice.controller.dto.LikeBookResponseDto;
import com.relation.jpa_practice.domain.LikeBook;
import com.relation.jpa_practice.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.relation.jpa_practice.controller.dto.ApiForm.succed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class LikePostController {
    private final LikeService likeService;

    @PostMapping("/{member_id}/like/{book_id}")
    public ApiForm<Long> saveLike(@PathVariable(name = "member_id") Long m_id, @PathVariable(name = "book_id") Long b_id){
        return succed(likeService.saveLike(m_id, b_id));
    }

    @GetMapping("/likes")
    public ApiForm<List<LikeBookResponseDto>> findLikes(){
        return succed(likeService.findLikes());
    }
}
