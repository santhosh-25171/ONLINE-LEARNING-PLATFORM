package com.learning.repository;

import com.learning.models.Review;

public class ReviewRepository extends InMemoryRepository<Review> {
    public ReviewRepository() {
        super(Review::getReviewId);
    }
}
