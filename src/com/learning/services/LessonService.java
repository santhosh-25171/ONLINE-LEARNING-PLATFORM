package com.learning.services;

import com.learning.models.Lesson;
import com.learning.repository.LessonRepository;
import com.learning.repository.SectionRepository;

public class LessonService extends CrudService<Lesson> {
    private final SectionRepository sections;

    public LessonService(LessonRepository lessons, SectionRepository sections) {
        super(lessons);
        this.sections = sections;
    }

    @Override
    protected void validate(Lesson lesson) {
        require(lesson != null, "Lesson cannot be null");
        require(sections.findById(lesson.getSectionId()).isPresent(), "Section does not exist");
        requireText(lesson.getTitle(), "Title");
        requireText(lesson.getType(), "Type");
        require(lesson.getDuration() > 0, "Duration must be greater than zero");
        require(lesson.getOrderNumber() > 0, "Order number must be greater than zero");
    }
}
