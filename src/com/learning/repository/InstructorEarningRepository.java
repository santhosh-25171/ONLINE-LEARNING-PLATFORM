package com.learning.repository;

import com.learning.models.InstructorEarning;

public class InstructorEarningRepository extends InMemoryRepository<InstructorEarning> {
    public InstructorEarningRepository() {
        super(InstructorEarning::getEarningId);
    }
}
