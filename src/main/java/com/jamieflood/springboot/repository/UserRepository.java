package com.jamieflood.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamieflood.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
