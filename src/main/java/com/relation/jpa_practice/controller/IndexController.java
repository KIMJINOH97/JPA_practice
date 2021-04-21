package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.MemberResponseDto;
import com.relation.jpa_practice.controller.dto.MemberUpdateDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model){
        List<MemberResponseDto> members = memberService.findall();
        model.addAttribute("members", members);
        return "index";
    }

    @GetMapping("/api/member/{id}")
    public String findMemberById(Model model, @PathVariable Long id){
        MemberResponseDto member = memberService.findById(id);
        model.addAttribute("member", member);
        return "memberInfo";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello.html";
    }
}
