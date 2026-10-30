package com.learning.services;

import com.learning.models.Section;
import com.learning.repository.CourseRepository;
import com.learning.repository.SectionRepository;

public class SectionService extends CrudService<Section> {
    private final CourseRepository courses;

    public SectionService(SectionRepository sections, CourseRepository courses) {
        super(sections);
        this.courses = courses;
    }

    @Override
    protected void validate(Section section) {
        require(section != null, "Section cannot be null");
        require(courses.findById(section.getCourseId()).isPresent(), "Course does not exist");
        requireText(section.getTitle(), "Title");
        require(section.getOrderNumber() > 0, "Order number must be greater than zero");
    }
}
