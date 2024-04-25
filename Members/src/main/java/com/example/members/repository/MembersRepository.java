package com.example.members.repository;

import com.example.members.model.Members;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
	
	Optional<Members> findById(String id);
	void deleteById(String id);
}
