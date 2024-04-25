package com.example.catalogue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogue.model.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
	Optional<Catalogue> findById(String id);
	void deleteById(String id);
}

