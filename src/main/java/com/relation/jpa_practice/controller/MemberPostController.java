package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.ApiForm;
import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.relation.jpa_practice.controller.dto.ApiForm.succed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class MemberPostController {
    private final MemberService memberService;

    @PostMapping("/member/{team_id}")
    public ApiForm<Long> save(@PathVariable Long team_id, @RequestBody MemberRequestDto requestDto){
        return succed(memberService.save(team_id, requestDto));
    }

    @GetMapping("/members")
    public ApiForm<List<Member>> findall(){
        return succed(memberService.findall());
    }

    @GetMapping("/member")
    public ApiForm<List<Member>> findByAge(@RequestParam String age){
        int a = Integer.parseInt(age);
        System.out.println(a);
        return succed(memberService.findByAge(a));
    }

}
