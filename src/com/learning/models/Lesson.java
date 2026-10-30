package com.learning.models;

public class Lesson {
    private int lessonId;
    private int sectionId;
    private String title;
    private String type;
    private int duration;
    private int orderNumber;

    public Lesson(int lessonId, int courseId, String title,
                  String type, int duration) {
        this(lessonId, courseId, title, type, duration, 1);
    }

    public Lesson(int lessonId, int sectionId, String title,
                  String type, int duration, int orderNumber) {
        this.lessonId = lessonId;
        this.sectionId = sectionId;
        this.title = title;
        this.type = type;
        this.duration = duration;
        this.orderNumber = orderNumber;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getCourseId() {
        return sectionId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}