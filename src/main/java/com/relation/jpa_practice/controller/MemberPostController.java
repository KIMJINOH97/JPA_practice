package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.TeamResponseDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/post/members")
    public List<Member> findall(){
        return memberService.findall();
    }

    @GetMapping("/api/post/member")
    public List<Member> findByAge(@RequestParam String age){
        int a = Integer.parseInt(age);
        System.out.println(a);
        return memberService.findByAge(a);
    }

}
