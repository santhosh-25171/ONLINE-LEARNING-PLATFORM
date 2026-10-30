package com.learning.models;

public class Course {

    private int courseId;
    private int instructorId;
    private String title;
    private String description;
    private String category;
    private String level;
    private double price;
    private String status;
    private double averageRating;

    public Course(int courseId, int instructorId, String title,
                  String category, String level, double price) {
        this(courseId, instructorId, title, "", category, level, price, "Draft", 0.0);
    }

    public Course(int courseId, int instructorId, String title, String description,
                  String category, String level, double price, String status,
                  double averageRating) {
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.level = level;
        this.price = price;
        this.status = status;
        this.averageRating = averageRating;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}