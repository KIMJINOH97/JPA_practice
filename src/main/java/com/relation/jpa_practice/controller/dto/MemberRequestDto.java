package com.relation.jpa_practice.controller.dto;

import com.relation.jpa_practice.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberRequestDto {

    public String name;
    public int age;

    public Member toEntity(){
        return new Member(name, age);
    }

}