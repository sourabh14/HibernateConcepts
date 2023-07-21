package com.example.HibernateConcepts.repository;

import com.example.HibernateConcepts.entity.person.EmailGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailGroupRepository extends JpaRepository<EmailGroup, Long> {
}
