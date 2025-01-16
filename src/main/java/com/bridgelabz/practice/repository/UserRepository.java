package com.bridgelabz.practice.repository;

import com.bridgelabz.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
