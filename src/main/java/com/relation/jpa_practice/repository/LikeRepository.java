package com.relation.jpa_practice.repository;

import com.relation.jpa_practice.domain.LikeBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeBook, Long> {
}
