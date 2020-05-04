package com.example.SpringOAuthService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringOAuthService.model.User;

public interface AuthRepository extends  JpaRepository<User ,Long>{

}
