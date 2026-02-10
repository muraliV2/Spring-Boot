package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;
import com.example.userdto.Userdto;

 

public interface UserRepository extends JpaRepository<User, Integer> {
}
