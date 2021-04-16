package com.relation.jpa_practice.repository;

import com.relation.jpa_practice.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // 팀 이름으로 멤버를 찾는 로직
    @Query("select t from Team t where t.name = ?1")
    Team findByTeamName(String name);
}
