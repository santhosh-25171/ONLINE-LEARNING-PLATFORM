package com.learning.repository;

import com.learning.models.QuizAttempt;

public class QuizAttemptRepository extends InMemoryRepository<QuizAttempt> {
    public QuizAttemptRepository() {
        super(QuizAttempt::getAttemptId);
    }
}
