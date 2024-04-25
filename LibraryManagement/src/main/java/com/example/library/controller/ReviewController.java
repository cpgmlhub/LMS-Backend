package com.example.library.controller;

import com.example.library.config.ReviewFeignClient;
import com.example.library.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewFeignClient reviewFeignClient;

    @Autowired
    public ReviewController(ReviewFeignClient reviewFeignClient) {
        this.reviewFeignClient = reviewFeignClient;
    }

    @PostMapping("/create-review")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewFeignClient.createReview(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/view-reviews")
    public ResponseEntity<List<Review>> viewReviews() {
        List<Review> reviews = reviewFeignClient.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping("/delete-review/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id) {
        return reviewFeignClient.deleteReview(id);
    }

    @GetMapping("/search-review/{id}")
    public ResponseEntity<Review> searchReviewById(@PathVariable String id) {
        return reviewFeignClient.getReviewById(id);
    }
}
