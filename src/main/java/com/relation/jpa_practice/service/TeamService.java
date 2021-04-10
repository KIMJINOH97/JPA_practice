package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.controller.dto.TeamResponseDto;
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
    public List<Team> findall(){
        return teamRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Member> findMember(Long id){
        return teamRepository.findById(id).get().getMembers();
    }

    @Transactional(readOnly = true)
    public List<Member> findByName(String name){
        Team team = teamRepository.findByName(name);
        return team.getMembers();
    }

}
