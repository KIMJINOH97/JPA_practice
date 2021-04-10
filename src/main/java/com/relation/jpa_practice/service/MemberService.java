package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.MemberRepository;
import com.relation.jpa_practice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public Long save(Long team_id ,MemberRequestDto requestDto){
        Team team = teamRepository.findById(team_id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 ID 입니다."));
        Member member = requestDto.toEntity();
        member.setTeam(team);
        return memberRepository.save(member).getId();
    }

}