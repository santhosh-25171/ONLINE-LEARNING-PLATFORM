package com.learning.services;

import com.learning.models.Course;
import com.learning.models.Enrollment;
import com.learning.models.User;
import com.learning.repository.CourseRepository;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.UserRepository;

public class EnrollmentService extends CrudService<Enrollment> {
    private final UserRepository users;
    private final CourseRepository courses;

    public EnrollmentService(EnrollmentRepository enrollments, UserRepository users,
                             CourseRepository courses) {
        super(enrollments);
        this.users = users;
        this.courses = courses;
    }

    @Override
    protected void validate(Enrollment enrollment) {
        require(enrollment != null, "Enrollment cannot be null");
        User student = users.findById(enrollment.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student does not exist"));
        require("STUDENT".equalsIgnoreCase(student.getRole()),
                "Enrollment owner must have the STUDENT role");
        Course course = courses.findById(enrollment.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course does not exist"));
        requireText(course.getStatus(), "Course status");
        requireText(enrollment.getStatus(), "Status");
        requireRange(enrollment.getProgressPercentage(), 0, 100, "Progress percentage");
        require(enrollment.getEnrollmentDate() != null, "Enrollment date is required");
    }
}
