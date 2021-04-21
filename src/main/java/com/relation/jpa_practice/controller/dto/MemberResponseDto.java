package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberResponseDto {
    private Long id;
    private String name;
    private int age;
    private String teamName;
    private AddressResponseDto address;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
        this.address = new AddressResponseDto(member.getAddress());
        this.teamName = member.getTeam().getName();
    }
}
