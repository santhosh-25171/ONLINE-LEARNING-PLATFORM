package com.learning.services;

import com.learning.models.Enrollment;
import com.learning.models.Lesson;
import com.learning.models.LessonProgress;
import com.learning.models.Section;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.LessonProgressRepository;
import com.learning.repository.LessonRepository;
import com.learning.repository.SectionRepository;

public class LessonProgressService extends CrudService<LessonProgress> {
    private final EnrollmentRepository enrollments;
    private final LessonRepository lessons;
    private final SectionRepository sections;

    public LessonProgressService(LessonProgressRepository progress,
                                 EnrollmentRepository enrollments,
                                 LessonRepository lessons,
                                 SectionRepository sections) {
        super(progress);
        this.enrollments = enrollments;
        this.lessons = lessons;
        this.sections = sections;
    }

    @Override
    protected void validate(LessonProgress progress) {
        require(progress != null, "Lesson progress cannot be null");
        Enrollment enrollment = enrollments.findById(progress.getEnrollmentId())
                .orElseThrow(() -> new IllegalArgumentException("Enrollment does not exist"));
        Lesson lesson = lessons.findById(progress.getLessonId())
                .orElseThrow(() -> new IllegalArgumentException("Lesson does not exist"));
        Section section = sections.findById(lesson.getSectionId())
                .orElseThrow(() -> new IllegalArgumentException("Lesson section does not exist"));
        require(enrollment.getCourseId() == section.getCourseId(),
                "Lesson must belong to the enrolled course");
        requireRange(progress.getWatchedPercentage(), 0, 100, "Watched percentage");
        require(!progress.isCompleted() || progress.getCompletedDate() != null,
                "Completed date is required for completed progress");
    }
}
