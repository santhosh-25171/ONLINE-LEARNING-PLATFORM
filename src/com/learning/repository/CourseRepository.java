package com.learning.repository;

import com.learning.models.Course;

public class CourseRepository extends InMemoryRepository<Course> {
    public CourseRepository() {
        super(Course::getCourseId);
    }
}