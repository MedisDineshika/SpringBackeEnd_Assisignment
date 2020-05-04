package com.example.SpringOAuthService.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringOAuthService.model.User;

public interface UserDetailRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findByUsername(String name);

}
