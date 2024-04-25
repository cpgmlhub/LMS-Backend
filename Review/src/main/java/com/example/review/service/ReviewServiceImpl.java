package com.example.review.service;

import com.example.review.model.Review;
import com.example.review.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(String memberId, String itemId, String comment, int rating) {
    	long reviewCount = reviewRepository.count();
        Review review = new Review();
        review.setId(generateId(reviewCount));
        review.setMemberId(memberId);
        review.setItemId(itemId);
        review.setComment(comment);
        review.setRating(rating);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteReviewById(String id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
    }
	  
    private String generateId(long reviewCount) {
	  // String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   char firstChar = 'R'; // Always use 'C' as the first character
	   
	   // Format the running numbers to have leading zeros (e.g., "0001")
	   String runningNumbers = String.format("%04d", reviewCount);
	   
	   // Concatenate the first character and running numbers
	   return firstChar + runningNumbers;
	}


	@Override
	public Long getNextReviewCountFromDatabase() {
	   // This method queries the database to get the current catalogue count
	   // It uses the count() method provided by Spring Data JPA repository
	   long reviewCount = reviewRepository.count();
	   // Increment the count by 1 for the next ID
	   return reviewCount + 1;
	}


}
