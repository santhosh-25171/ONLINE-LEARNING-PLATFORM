package com.learning.models;

public class Section {
    private int sectionId;
    private int courseId;
    private String title;
    private int orderNumber;

    public Section(int sectionId, int courseId, String title, int orderNumber) {
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.title = title;
        this.orderNumber = orderNumber;
    }

    public int getSectionId() { return sectionId; }
    public int getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public int getOrderNumber() { return orderNumber; }
}
