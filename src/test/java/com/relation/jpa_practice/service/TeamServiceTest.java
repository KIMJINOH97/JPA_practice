package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.*;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.repository.MemberRepository;
import com.relation.jpa_practice.repository.TeamRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class TeamServiceTest {
    @Autowired private TeamService teamService;
    @Autowired private TeamRepository teamRepository;
    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;

    @AfterEach
    public void deleteAll(){
        teamRepository.deleteAll();
    }

    @Test
    public void save(){
        //given
        String name = "new_team";
        TeamRequestDto requestDto = new TeamRequestDto(name);

        //when
        teamService.save(requestDto);

        //then
        Team team = teamRepository.findById(6L).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 ID 입니다."));

        assertThat(team.getName()).isEqualTo(name);
    }

    @Test
    public void findById(){
        //given
        String t_name = "new_team";

        //when
        Team new_team = teamRepository.save(new Team(t_name));
        System.out.println(new_team.getId());
        //then
        Team team = teamRepository.findById(6L).get();
        assertThat(team.getName()).isEqualTo(t_name);
    }

    @Test
    public void findAll(){
        List<TeamListResponseDto> teamList = teamService.findall();
        assertThat(teamList.size()).isEqualTo(5);
    }

    @Test
    public void findByNameTeam(){
        //given
        String new_team = "new_team";

        Team team = new Team(new_team);

        //when
        teamRepository.save(team);

        //then
        TeamResponseDto findTeam = teamService.findByTeamName(new_team);
        assertThat(findTeam.getName()).isEqualTo(new_team);

    }

    @Test
    public void findTeamMembers(){
        //given
        String m_name = "ji young";
        String m_name2 = "ji ji";
        int age = 24;

        Team team = teamRepository.findById(5L).get();
        Member member1 = new Member(m_name, age);
        Member member2 = new Member(m_name2, age);

        member2.setTeam(team);
        member1.setTeam(team);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);

        //then
        List<MemberResponseDto> teamMembers = teamService.findTeamMembers(5L);
        assertThat(teamMembers.size()).isEqualTo(2);

    }

}