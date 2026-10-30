package com.learning.models;

public class Course {

    private int courseId;
    private int instructorId;
    private String title;
    private String category;
    private String level;
    private double price;
    private String status;

    public Course(int courseId, int instructorId, String title,
                  String category, String level, double price) {

        this.courseId = courseId;
        this.instructorId = instructorId;
        this.title = title;
        this.category = category;
        this.level = level;
        this.price = price;
        this.status = "Draft";
    }

    public int getCourseId() {
        return courseId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getLevel() {
        return level;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}