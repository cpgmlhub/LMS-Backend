package com.example.acquisition.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.acquisition.model.Acquisition;

public interface AcquisitionRepository extends JpaRepository<Acquisition, Long> {
	Optional<Acquisition> findById(String id);
	void deleteById(String id);
}

