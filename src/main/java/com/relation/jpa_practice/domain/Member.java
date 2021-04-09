package com.relation.jpa_practice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setTeam(Team team){
        this.team = team;
    }

}
