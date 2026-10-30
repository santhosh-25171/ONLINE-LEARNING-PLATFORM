package com.learning.services;

import com.learning.models.Review;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.ReviewRepository;

public class ReviewService extends CrudService<Review> {
    private final EnrollmentRepository enrollments;

    public ReviewService(ReviewRepository reviews, EnrollmentRepository enrollments) {
        super(reviews);
        this.enrollments = enrollments;
    }

    @Override
    protected void validate(Review review) {
        require(review != null, "Review cannot be null");
        require(enrollments.findById(review.getEnrollmentId()).isPresent(),
                "Enrollment does not exist");
        requireRange(review.getRating(), 1, 5, "Rating");
        requireText(review.getComment(), "Comment");
        require(review.getReviewDate() != null, "Review date is required");
    }
}
