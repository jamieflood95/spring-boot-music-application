package com.jamieflood.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamieflood.springboot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
