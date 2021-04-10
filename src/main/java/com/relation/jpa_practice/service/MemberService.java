package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.MemberRepository;
import com.relation.jpa_practice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Long team_id ,MemberRequestDto requestDto){
        Team team = teamRepository.findById(team_id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 ID 입니다."));
        Member member = requestDto.toEntity();
        member.setTeam(team);
        return memberRepository.save(member).getId();
    }

    @Transactional(readOnly = true)
    public List<Member> findall(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Member> findByAge(int age){
        return memberRepository.findByAge(age);
    }

}
