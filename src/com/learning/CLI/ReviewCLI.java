package com.learning.CLI;

import com.learning.models.Review;
import com.learning.services.ReviewService;
import java.util.Scanner;

public final class ReviewCLI extends CrudMenu<Review> {
    public ReviewCLI(ReviewService service) {
        super("Reviews", service);
    }

    @Override
    protected Review readEntity(Scanner input) {
        return new Review(CliInput.readInt(input, "Review ID: "),
                CliInput.readInt(input, "Enrollment ID: "),
                CliInput.readInt(input, "Rating: "),
                CliInput.readLine(input, "Comment: "),
                CliInput.readDate(input, "Review date (YYYY-MM-DD): ", false, null));
    }

    @Override
    protected String describe(Review review) {
        return "Review{id=" + review.getReviewId() + ", enrollmentId="
                + review.getEnrollmentId() + ", rating=" + review.getRating()
                + ", comment='" + review.getComment() + "', date="
                + review.getReviewDate() + "}";
    }
}
