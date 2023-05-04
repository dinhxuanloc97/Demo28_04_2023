package com.example.miniproject.model.repository;

import com.example.miniproject.model.entity.ERoles;
import com.example.miniproject.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName(ERoles roleName);
}
