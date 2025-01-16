package com.bridgelabz.practice.repository;

import com.bridgelabz.practice.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<Image, Integer> {
}
