package com.example.spandy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spandy.model.User;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUsername(String username);
}