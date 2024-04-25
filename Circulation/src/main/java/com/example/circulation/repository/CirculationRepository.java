package com.example.circulation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.circulation.model.Circulation;

public interface CirculationRepository extends JpaRepository<Circulation, Long> {
	Optional<Circulation> findById(String id);
	void deleteById(String id);
}

