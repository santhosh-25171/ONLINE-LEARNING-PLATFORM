package com.learning.models;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private String status;
    private double progressPercentage;

    public Enrollment(int enrollmentId, int studentId, int courseId) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = "Pending Payment";
        this.progressPercentage = 0.0;
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
}