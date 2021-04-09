package com.relation.jpa_practice.service;

import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Long save(TeamRequestDto requestDto){
        return teamRepository.save(new Team(requestDto.getName())).getId();
    }

}
