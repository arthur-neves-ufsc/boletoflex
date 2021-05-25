package com.boletoflex.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boletoflex.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findById(Integer id);
}
