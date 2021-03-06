package com.relation.jpa_practice.service;


import com.relation.jpa_practice.controller.dto.*;
import com.relation.jpa_practice.domain.Address;
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
        List<Team> teamList = teamRepository.findAll();
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
        Address address = new Address("서울", "마포", "상수");


        Team team = teamRepository.findById(5L).get();
        //System.out.println("팀 회원 크기: " + team.getMembers().size());

        Member member1 = new Member(m_name, age, address);
        Member member2 = new Member(m_name2, age, address);

        member2.setTeam(team);
        member1.setTeam(team);
        //System.out.println("넣은 뒤 사이즈" + team.getMembers().size());
        //when
        memberRepository.save(member1);
        //System.out.println("넣은 뒤 사이즈" + team.getMembers().size());
        memberRepository.save(member2);
        //System.out.println("넣은 뒤 사이즈" + team.getMembers().size());
        //then
        List<MemberResponseDto> teamMembers = teamService.findTeamMembers(5L);

        for (MemberResponseDto mr : teamMembers){
            System.out.println(mr.getId() + mr.getName());
        }

        assertThat(teamMembers.size()).isEqualTo(3);
//        Optional<Team> byId = teamRepository.findById(5L);
  //      System.out.println(byId.get().getMembers().size());

    }

    @Test
    public void findTeamMember(){
        //given
        String m_name = "ji young";
        String m_name2 = "ji ji";
        int age = 24;
        Address address = new Address("서울", "마포", "상수");


        Team team = teamRepository.findById(5L).get();
        Member member1 = new Member(m_name, age, address);
        Member member2 = new Member(m_name2, age, address);

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