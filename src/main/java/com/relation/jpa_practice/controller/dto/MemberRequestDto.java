package com.relation.jpa_practice.controller.dto;

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

    public Member toEntity(){
        return new Member(name, age, new Address(address));
    }

}
