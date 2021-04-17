package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.MemberResponseDto;
import com.relation.jpa_practice.controller.dto.TeamListResponseDto;
import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.controller.dto.TeamResponseDto;
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
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Long save(TeamRequestDto requestDto){
        return teamRepository.save(new Team(requestDto.getName())).getId();
    }

    @Transactional
    public TeamResponseDto findById(Long id){
        Team team = teamRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("실패"));
        return new TeamResponseDto(team);
    }

    @Transactional(readOnly = true)
    public List<TeamListResponseDto> findall(){
        List<Team> all = teamRepository.findAll();
        List<TeamListResponseDto> responseDtos = new ArrayList<TeamListResponseDto>();
        for (Team team : all){
            responseDtos.add(new TeamListResponseDto(team));
        }
        return responseDtos;
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findTeamMembers(Long id){
        List<Member> members= teamRepository.findById(id).get().getMembers();
        List<MemberResponseDto> responseDtos = new ArrayList<MemberResponseDto>();
        for (Member member: members){
            responseDtos.add(new MemberResponseDto(member));
        }
        return responseDtos;
    }

    // 팀 이름으로 소속 멤버를 찾음
    @Transactional(readOnly = true)
    public TeamResponseDto findByTeamName(String name){
        return new TeamResponseDto(teamRepository.findByTeamName(name));
    }

}
