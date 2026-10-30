package com.learning.services;

import com.learning.models.Course;
import com.learning.models.Enrollment;
import com.learning.models.InstructorEarning;
import com.learning.repository.CourseRepository;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.InstructorEarningRepository;

public class InstructorEarningService extends CrudService<InstructorEarning> {
    private final CourseRepository courses;
    private final EnrollmentRepository enrollments;

    public InstructorEarningService(InstructorEarningRepository earnings,
                                    CourseRepository courses,
                                    EnrollmentRepository enrollments) {
        super(earnings);
        this.courses = courses;
        this.enrollments = enrollments;
    }

    @Override
    protected void validate(InstructorEarning earning) {
        require(earning != null, "Instructor earning cannot be null");
        Course course = courses.findById(earning.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course does not exist"));
        Enrollment enrollment = enrollments.findById(earning.getEnrollmentId())
                .orElseThrow(() -> new IllegalArgumentException("Enrollment does not exist"));
        require(course.getCourseId() == enrollment.getCourseId(),
                "Earning course must match the enrollment course");
        requireNonNegative(earning.getInstructorShare(), "Instructor share");
        requireNonNegative(earning.getPlatformShare(), "Platform share");
        requireText(earning.getStatus(), "Status");
    }
}
