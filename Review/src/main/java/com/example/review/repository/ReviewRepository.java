package com.example.review.repository;

import com.example.review.model.Review;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	Optional<Review> findById(String id);
	void deleteById(String id);
}
