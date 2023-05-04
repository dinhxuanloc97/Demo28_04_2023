package com.example.miniproject.model.repository;

import com.example.miniproject.model.entity.Emloyee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmloyeeRepository extends JpaRepository<Emloyee, Integer> {
    boolean existsByEmail(String email);
}
