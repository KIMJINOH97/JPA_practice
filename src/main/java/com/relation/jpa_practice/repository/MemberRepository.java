package com.relation.jpa_practice.repository;

import com.relation.jpa_practice.domain.Member;
import com.relation.jpa_practice.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.age = :age")
    List<Member> findByAge(@Param("age") int age);
}
