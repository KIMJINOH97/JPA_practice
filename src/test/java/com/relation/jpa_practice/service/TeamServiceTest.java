package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.controller.dto.TeamResponseDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.MemberRepository;
import com.relation.jpa_practice.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class TeamServiceTest {
    @Autowired private TeamService teamService;
    @Autowired private TeamRepository teamRepository;
    @Autowired private MemberService memberService;


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

    @Test
    public void findById(){
        //given
        String t_name = "team1";
        String m_name = "kimjinoh";
        int m_age = 24;

        MemberRequestDto requestDto = new MemberRequestDto(m_name, m_age);

        //when
        teamRepository.save(new Team(t_name));
        memberService.save(1L, requestDto);

        //then
        Team team = teamRepository.findById(1L).get();
        assertThat(team.getMembers().size()).isEqualTo(1);
    }

    @Test
    public void findall(){
        //given
        String team1 = "team1";
        String team2 = "team2";
        String team3 = "team3";

        //when
        teamRepository.save(new Team(team1));
        teamRepository.save(new Team(team2));
        teamRepository.save(new Team(team3));

        //then
        List<Team> teamList = teamService.findall();
        assertThat(teamList.size()).isEqualTo(3);
    }

    @Test
    public void findTeam(){
        //given
        String team1 = "team1";
        String team2 = "team2";

        String name = "zino";
        int age = 24;

        //when
        teamRepository.save(new Team(team1));
        teamRepository.save(new Team(team2));
        memberService.save(1L, new MemberRequestDto(name, age));

        //then
        List<Member> member = teamService.findByName(team1);
        assertThat(member.size()).isEqualTo(1);

    }

}