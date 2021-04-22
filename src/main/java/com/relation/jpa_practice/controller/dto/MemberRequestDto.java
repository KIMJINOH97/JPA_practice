package com.relation.jpa_practice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.relation.jpa_practice.domain.Address;
import com.relation.jpa_practice.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequestDto {

    public String name;
    public int age;
    public AddressResponseDto address;
    @JsonProperty("team_name")
    public String teamName;

    public Member toEntity(){
        return new Member(name, age, new Address(address));
    }

}
