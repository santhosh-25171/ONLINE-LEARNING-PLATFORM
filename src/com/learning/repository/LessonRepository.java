package com.learning.repository;

import com.learning.models.Lesson;

public class LessonRepository extends InMemoryRepository<Lesson> {
    public LessonRepository() {
        super(Lesson::getLessonId);
    }
}
