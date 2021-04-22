package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.MemberResponseDto;
import com.relation.jpa_practice.controller.dto.MemberUpdateDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.MemberRepository;
import com.relation.jpa_practice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberRequestDto requestDto){
        Team team = teamRepository.findByTeamName(requestDto.getTeamName());
        Member member = requestDto.toEntity();
        member.setTeam(team);
        return memberRepository.save(member).getId();
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findall(){
        List<Member> members = memberRepository.findAll();
        List<MemberResponseDto> responseDtos = new ArrayList<MemberResponseDto>();
        for (Member member : members){
            responseDtos.add(new MemberResponseDto(member));
        }
        return responseDtos;
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findByAge(int age){
        List<Member> members = memberRepository.findByAge(age);
        List<MemberResponseDto> responseDtos = new ArrayList<MemberResponseDto>();
        for (Member member : members){
            responseDtos.add(new MemberResponseDto(member));
        }
        return responseDtos;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id){
        return new MemberResponseDto(memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 ID 입니다.")));
    }

    @Transactional
    public MemberResponseDto updateMember(Long id, MemberUpdateDto updateDto){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("no id"));
        Team team = teamRepository.findByTeamName(updateDto.getTeamName());
        member.update(updateDto);
        member.updateTeam(team);
        return new MemberResponseDto(member);
    }

    @Transactional
    public void deleteMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException());
        member.deleteTeam();
        memberRepository.delete(member);
    }
}
