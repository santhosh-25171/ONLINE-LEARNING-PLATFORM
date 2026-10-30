package com.learning.models;

import java.time.LocalDate;

public class Review {
    private int reviewId;
    private int enrollmentId;
    private int rating;
    private String comment;
    private LocalDate reviewDate;

    public Review(int reviewId, int enrollmentId, int rating, String comment,
                  LocalDate reviewDate) {
        this.reviewId = reviewId;
        this.enrollmentId = enrollmentId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public int getReviewId() { return reviewId; }
    public int getEnrollmentId() { return enrollmentId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public LocalDate getReviewDate() { return reviewDate; }
}
