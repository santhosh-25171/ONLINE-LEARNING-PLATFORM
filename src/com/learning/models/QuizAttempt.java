package com.learning.models;

import java.time.LocalDate;

public class QuizAttempt {
    private int attemptId;
    private int enrollmentId;
    private int lessonId;
    private int score;
    private boolean passed;
    private LocalDate attemptDate;

    public QuizAttempt(int attemptId, int enrollmentId, int lessonId, int score,
                       boolean passed, LocalDate attemptDate) {
        this.attemptId = attemptId;
        this.enrollmentId = enrollmentId;
        this.lessonId = lessonId;
        this.score = score;
        this.passed = passed;
        this.attemptDate = attemptDate;
    }

    public int getAttemptId() { return attemptId; }
    public int getEnrollmentId() { return enrollmentId; }
    public int getLessonId() { return lessonId; }
    public int getScore() { return score; }
    public boolean isPassed() { return passed; }
    public LocalDate getAttemptDate() { return attemptDate; }
}
