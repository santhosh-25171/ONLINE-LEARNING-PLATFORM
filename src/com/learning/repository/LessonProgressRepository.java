package com.learning.repository;

import com.learning.models.LessonProgress;

public class LessonProgressRepository extends InMemoryRepository<LessonProgress> {
    public LessonProgressRepository() {
        super(LessonProgress::getProgressId);
    }
}
