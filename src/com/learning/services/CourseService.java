package com.learning.services;

import com.learning.models.Course;
import com.learning.models.User;
import com.learning.repository.CourseRepository;
import com.learning.repository.UserRepository;

public class CourseService extends CrudService<Course> {
    private final UserRepository users;

    public CourseService(CourseRepository courses, UserRepository users) {
        super(courses);
        this.users = users;
    }

    @Override
    protected void validate(Course course) {
        require(course != null, "Course cannot be null");
        User instructor = users.findById(course.getInstructorId())
                .orElseThrow(() -> new IllegalArgumentException("Instructor does not exist"));
        require("INSTRUCTOR".equalsIgnoreCase(instructor.getRole()),
                "Course owner must have the INSTRUCTOR role");
        requireText(course.getTitle(), "Title");
        requireText(course.getCategory(), "Category");
        requireText(course.getLevel(), "Level");
        requireNonNegative(course.getPrice(), "Price");
        requireRange(course.getAverageRating(), 0, 5, "Average rating");
        requireText(course.getStatus(), "Status");
    }
}
