package com.relation.jpa_practice.repository;

import com.relation.jpa_practice.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
