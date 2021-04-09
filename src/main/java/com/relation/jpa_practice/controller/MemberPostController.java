package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.TeamResponseDto;
import com.relation.jpa_practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberPostController {
    private final MemberService memberService;

    @GetMapping("/")
    public String name(){
        return "index";
    }

    @PostMapping("/api/post/member/{team_id}")
    public Long save(@PathVariable Long team_id, @RequestBody MemberRequestDto requestDto){
        return memberService.save(team_id, requestDto);
    }

}
