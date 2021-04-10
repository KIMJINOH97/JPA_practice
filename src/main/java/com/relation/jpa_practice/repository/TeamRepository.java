package com.relation.jpa_practice.repository;

import com.relation.jpa_practice.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("select t from Team t where t.name = ?1")
    Team findByName(String name);
}
