package com.learning.repository;

import com.learning.models.Section;

public class SectionRepository extends InMemoryRepository<Section> {
    public SectionRepository() {
        super(Section::getSectionId);
    }
}
