package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.repository.MemberRepository;
import com.relation.jpa_practice.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberServiceTest {
    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;
    @Autowired private TeamRepository teamRepository;

    @Test
    public void save(){
        //given
        String team_name = "team1";
        TeamRequestDto teamRequestDto = new TeamRequestDto(team_name);


        String name = "jino";
        int age = 24;
        MemberRequestDto memberRequestDto = new MemberRequestDto(name, age);

        //when
        teamRepository.save(teamRequestDto.toEntity());
        memberService.save(1L, memberRequestDto);

        //then
        Member member = memberRepository.findById(1L).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 ID 입니다."));

        assertThat(member.getTeam().getId()).isEqualTo(1L);

    }


}