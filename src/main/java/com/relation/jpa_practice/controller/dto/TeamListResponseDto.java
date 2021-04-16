package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class TeamListResponseDto {
    private String name;
    private List<Member> members = new ArrayList<Member>();

    public TeamListResponseDto(Team team){
        this.name = team.getName();
        this.members = team.getMembers();
    }
}
