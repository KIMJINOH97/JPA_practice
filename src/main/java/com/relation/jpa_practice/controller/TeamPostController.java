package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.TeamListResponseDto;
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
@RequestMapping("/api/post")
public class TeamPostController {

    private final TeamService teamService;

    @PostMapping("/team")
    public Long save(@RequestBody TeamRequestDto requestDto){
        return teamService.save(requestDto);
    }

    @GetMapping("/team/{team_id}")
    public TeamResponseDto findById(@PathVariable Long team_id){
        return teamService.findById(team_id);
    }

    @GetMapping("/team") // /team?name=
    public TeamResponseDto findByTeamName(@RequestParam(name = "name") String team_name){
        return teamService.findByTeamName(team_name);
    }

    @GetMapping("/teams")
    public List<TeamListResponseDto> findall(){
        return teamService.findall();
    }

    @GetMapping("/team/{team_id}/member")
    public List<Member> findMember(@PathVariable Long team_id){
        return teamService.findMember(team_id);
    }



}
