package com.learning.models;

public class InstructorEarning {
    private int earningId;
    private int courseId;
    private int enrollmentId;
    private double instructorShare;
    private double platformShare;
    private String status;

    public InstructorEarning(int earningId, int courseId, int enrollmentId,
                             double instructorShare, double platformShare, String status) {
        this.earningId = earningId;
        this.courseId = courseId;
        this.enrollmentId = enrollmentId;
        this.instructorShare = instructorShare;
        this.platformShare = platformShare;
        this.status = status;
    }

    public int getEarningId() { return earningId; }
    public int getCourseId() { return courseId; }
    public int getEnrollmentId() { return enrollmentId; }
    public double getInstructorShare() { return instructorShare; }
    public double getPlatformShare() { return platformShare; }
    public String getStatus() { return status; }
}
