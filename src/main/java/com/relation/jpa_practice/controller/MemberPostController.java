package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.ApiForm;
import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.MemberResponseDto;
import com.relation.jpa_practice.controller.dto.MemberUpdateDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.relation.jpa_practice.controller.dto.ApiForm.succed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberPostController {
    private final MemberService memberService;

    // 회원 요청
    @PostMapping("/member")
    public ResponseEntity<Long> save(@RequestBody MemberRequestDto requestDto){
        return ResponseEntity.ok(memberService.save(requestDto));
    }

    // 회원 정보 수정
    @PutMapping("/member/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long id, @RequestBody MemberUpdateDto updateDto){
        return ResponseEntity.ok((memberService.updateMember(id, updateDto)));
    }

    // 회원 삭제
    @DeleteMapping("/member/{id}")
    public Long deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return id;
    }

    @GetMapping("/members")
    public ApiForm<List<MemberResponseDto>> findall(){
        return succed(memberService.findall());
    }

    @GetMapping("/member")
    public ApiForm<List<MemberResponseDto>> findByAge(@RequestParam String age){
        int a = Integer.parseInt(age);
        System.out.println(a);
        return succed(memberService.findByAge(a));
    }

}
