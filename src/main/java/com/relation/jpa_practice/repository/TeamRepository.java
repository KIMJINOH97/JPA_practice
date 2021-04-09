package com.relation.jpa_practice.repository;

import com.relation.jpa_practice.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
