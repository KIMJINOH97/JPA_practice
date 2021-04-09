package com.relation.jpa_practice.controller;

import com.relation.jpa_practice.controller.dto.MemberRequestDto;
import com.relation.jpa_practice.controller.dto.TeamRequestDto;
import com.relation.jpa_practice.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TeamPostController {

    private final TeamService teamService;

    @PostMapping("/api/post/team")
    public Long save(@RequestBody TeamRequestDto teamRequestDto){
        return teamService.save(teamRequestDto);
    }
}
