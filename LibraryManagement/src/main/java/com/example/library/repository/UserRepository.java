package com.example.library.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}