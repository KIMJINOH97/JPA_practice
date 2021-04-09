package com.relation.jpa_practice.repository;

import com.relation.jpa_practice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
