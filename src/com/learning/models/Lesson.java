package com.learning.models;

public class Lesson {
    private int lessonId;
    private int courseId;
    private String title;
    private String type;
    private int duration;

    public Lesson(int lessonId, int courseId, String title,
                  String type, int duration) {
        this.lessonId = lessonId;
        this.courseId = courseId;
        this.title = title;
        this.type = type;
        this.duration = duration;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getCourseId() {
        return courseId;
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
}