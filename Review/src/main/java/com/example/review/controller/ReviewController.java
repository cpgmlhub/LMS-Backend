package com.example.review.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.review.model.Review;
import com.example.review.service.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create-review")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(
            review.getMemberId(),
            review.getItemId(),
            review.getComment(),
            review.getRating()
        );
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
    
    @GetMapping("/view-reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
    
    @Transactional
    @DeleteMapping("/delete-review/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully");
    }
    
    @GetMapping("/search-review/{id}")
    public ResponseEntity<Review> searchReviewById(@PathVariable String id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
