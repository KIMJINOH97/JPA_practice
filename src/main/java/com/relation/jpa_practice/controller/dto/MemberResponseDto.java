package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberResponseDto {
    private String name;
    private String teamName;

    public MemberResponseDto(Member member){
        this.name = member.getName();
        this.teamName = member.getTeam().getName();
    }
}
