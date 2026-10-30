package com.learning.CLI;

import com.learning.models.Lesson;
import com.learning.services.LessonService;
import java.util.Scanner;

public final class LessonCLI extends CrudMenu<Lesson> {
    public LessonCLI(LessonService service) {
        super("Lessons", service);
    }

    @Override
    protected Lesson readEntity(Scanner input) {
        return new Lesson(CliInput.readInt(input, "Lesson ID: "),
                CliInput.readInt(input, "Section ID: "),
                CliInput.readLine(input, "Title: "),
                CliInput.readLine(input, "Type: "),
                CliInput.readInt(input, "Duration (minutes): "),
                CliInput.readInt(input, "Order number: "));
    }

    @Override
    protected String describe(Lesson lesson) {
        return "Lesson{id=" + lesson.getLessonId() + ", sectionId="
                + lesson.getSectionId() + ", title='" + lesson.getTitle()
                + "', type='" + lesson.getType() + "', duration="
                + lesson.getDuration() + ", order=" + lesson.getOrderNumber() + "}";
    }
}
