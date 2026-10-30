package com.learning.services;

import com.learning.models.Enrollment;
import com.learning.models.Lesson;
import com.learning.models.QuizAttempt;
import com.learning.models.Section;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.LessonRepository;
import com.learning.repository.QuizAttemptRepository;
import com.learning.repository.SectionRepository;

public class QuizAttemptService extends CrudService<QuizAttempt> {
    private final EnrollmentRepository enrollments;
    private final LessonRepository lessons;
    private final SectionRepository sections;

    public QuizAttemptService(QuizAttemptRepository attempts,
                              EnrollmentRepository enrollments,
                              LessonRepository lessons,
                              SectionRepository sections) {
        super(attempts);
        this.enrollments = enrollments;
        this.lessons = lessons;
        this.sections = sections;
    }

    @Override
    protected void validate(QuizAttempt attempt) {
        require(attempt != null, "Quiz attempt cannot be null");
        Enrollment enrollment = enrollments.findById(attempt.getEnrollmentId())
                .orElseThrow(() -> new IllegalArgumentException("Enrollment does not exist"));
        Lesson lesson = lessons.findById(attempt.getLessonId())
                .orElseThrow(() -> new IllegalArgumentException("Lesson does not exist"));
        Section section = sections.findById(lesson.getSectionId())
                .orElseThrow(() -> new IllegalArgumentException("Lesson section does not exist"));
        require(enrollment.getCourseId() == section.getCourseId(),
                "Quiz lesson must belong to the enrolled course");
        require(attempt.getScore() >= 0, "Score must be non-negative");
        require(attempt.getAttemptDate() != null, "Attempt date is required");
    }
}
