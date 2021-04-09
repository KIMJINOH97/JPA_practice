package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TeamResponseDto {
    public Long id;
    public String name;

    public List<Member> members = new ArrayList<>();

    public TeamResponseDto(Team team){
        this.id = team.getId();
        this.name = team.getName();
        this.members = team.getMembers();
    }
}
