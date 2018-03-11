package com.project.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.clinic.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

	User findOneByEmail(String email);
	
}
