package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TeamServiceTest {
    @Autowired private TeamService teamService;
    @Autowired private TeamRepository teamRepository;

    @Test
    public void save(){
        //given
        String name = "team1";

        TeamRequestDto requestDto = new TeamRequestDto(name);

        //when
        teamService.save(requestDto);

        //then
        Team team = teamRepository.findById(1L).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 ID 입니다."));

        assertThat(team.getName()).isEqualTo(name);

    }

}