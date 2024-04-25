package com.example.library.config;

import com.example.library.model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Review", url = "${review.service.url}")
public interface ReviewFeignClient {

    @PostMapping("/review/create-review")
    Review createReview(@RequestBody Review review);

    @GetMapping("/review/view-reviews")
    List<Review> getAllReviews();

    @DeleteMapping("/review/delete-review/{id}")
    ResponseEntity<String> deleteReview(@PathVariable String id);

    @GetMapping("/review/search-review/{id}")
    ResponseEntity<Review> getReviewById(@PathVariable String id);
}
