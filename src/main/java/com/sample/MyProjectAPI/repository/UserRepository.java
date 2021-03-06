package com.sample.MyProjectAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.MyProjectAPI.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
	
	Users findByEmailAndPassword(	String email,
									String password);

	Users findByEmail(String email);

}
