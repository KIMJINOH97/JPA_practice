package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TeamRequestDto {
    public String name;
    public Team toEntity(){
        return new Team(name);
    }
}
