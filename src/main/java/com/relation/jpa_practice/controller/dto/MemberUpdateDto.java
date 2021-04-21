package com.relation.jpa_practice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberUpdateDto {
    private String name;
    private int age;
    private String city;
    private String gu;
    private String dong;

    @JsonProperty("team_name")
    private String teamName;
}
