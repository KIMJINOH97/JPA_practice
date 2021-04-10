package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.controller.dto.TeamResponseDto;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeamPostController {

    private final TeamService teamService;

    @PostMapping("/api/post/team")
    public Long save(@RequestBody TeamRequestDto requestDto){
        return teamService.save(requestDto);
    }

    @GetMapping("/api/post/team/{team_id}")
    public TeamResponseDto findById(@PathVariable Long team_id){
        return teamService.findById(team_id);
    }

    @GetMapping("/api/post/teams")
    public List<Team> findall(){
        return teamService.findall();
    }

    @GetMapping("/api/post/team/{team_id}/member")
    public List<Member> findMember(@PathVariable Long team_id){
        return teamService.findMember(team_id);
    }

    @GetMapping("/api/post/team/name={team_name}")
    public List<Member> findByName(@PathVariable String team_name){
        return teamService.findByName(team_name);
    }

}
