package com.relation.jpa_practice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Embedded
    private Address address;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<LikeBook> likeBooks = new ArrayList<LikeBook>();

    public Member(String name, int age, Address address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setTeam(Team team){
        this.team = team;
    }

}
