package com.learning.repository;

import com.learning.models.Enrollment;

public class EnrollmentRepository extends InMemoryRepository<Enrollment> {
    public EnrollmentRepository() {
        super(Enrollment::getEnrollmentId);
    }
}