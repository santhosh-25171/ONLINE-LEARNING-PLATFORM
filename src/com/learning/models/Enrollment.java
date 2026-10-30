package com.learning.models;

import java.time.LocalDate;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private String status;
    private double progressPercentage;
    private LocalDate enrollmentDate;
    private LocalDate completionDate;

    public Enrollment(int enrollmentId, int studentId, int courseId) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = "Pending Payment";
        this.progressPercentage = 0.0;
        this.enrollmentDate = LocalDate.now();
    }

    public Enrollment(int enrollmentId, int studentId, int courseId, String status,
                      double progressPercentage, LocalDate enrollmentDate,
                      LocalDate completionDate) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
        this.progressPercentage = progressPercentage;
        this.enrollmentDate = enrollmentDate;
        this.completionDate = completionDate;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProgressPercentage(double progressPercentage) {
        if (progressPercentage >= 0 && progressPercentage <= 100) {
            this.progressPercentage = progressPercentage;
        }
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}