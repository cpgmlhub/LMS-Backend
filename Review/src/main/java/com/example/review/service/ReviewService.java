package com.example.review.service;

import com.example.review.model.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review createReview(String memberId, String itemId, String comment, int rating);
    List<Review> getAllReviews();
    void deleteReviewById(String id);
    Optional<Review> getReviewById(String id);
    Long getNextReviewCountFromDatabase();
}
