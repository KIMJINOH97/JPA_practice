package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.*;
import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import com.relation.jpa_practice.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.relation.jpa_practice.controller.dto.ApiForm.succed;

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
    public ApiForm<TeamResponseDto> findById(@PathVariable Long team_id){
        return succed(teamService.findById(team_id));
    }

    @GetMapping("/team") // /team?name=
    public ApiForm<TeamResponseDto> findByTeamName(@RequestParam(name = "name") String team_name){
        return succed(teamService.findByTeamName(team_name));
    }

    @GetMapping("/teams")
    public ApiForm<List<TeamListResponseDto>> findAll(){
        return succed(teamService.findall());
    }

    @GetMapping("/team/{team_id}/member")
    public ApiForm<List<MemberResponseDto>> findMember(@PathVariable Long team_id){
        return succed(teamService.findTeamMembers(team_id));
    }



}
