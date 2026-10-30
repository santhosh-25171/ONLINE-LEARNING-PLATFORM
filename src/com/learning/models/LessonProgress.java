package com.learning.models;

import java.time.LocalDate;

public class LessonProgress {
    private int progressId;
    private int enrollmentId;
    private int lessonId;
    private boolean completed;
    private double watchedPercentage;
    private LocalDate completedDate;

    public LessonProgress(int progressId, int enrollmentId, int lessonId, boolean completed,
                          double watchedPercentage, LocalDate completedDate) {
        this.progressId = progressId;
        this.enrollmentId = enrollmentId;
        this.lessonId = lessonId;
        this.completed = completed;
        this.watchedPercentage = watchedPercentage;
        this.completedDate = completedDate;
    }

    public int getProgressId() { return progressId; }
    public int getEnrollmentId() { return enrollmentId; }
    public int getLessonId() { return lessonId; }
    public boolean isCompleted() { return completed; }
    public double getWatchedPercentage() { return watchedPercentage; }
    public LocalDate getCompletedDate() { return completedDate; }
}
