package com.learning.CLI;

import com.learning.models.Section;
import com.learning.services.SectionService;
import java.util.Scanner;

public final class SectionCLI extends CrudMenu<Section> {
    public SectionCLI(SectionService service) {
        super("Sections", service);
    }

    @Override
    protected Section readEntity(Scanner input) {
        return new Section(CliInput.readInt(input, "Section ID: "),
                CliInput.readInt(input, "Course ID: "),
                CliInput.readLine(input, "Title: "),
                CliInput.readInt(input, "Order number: "));
    }

    @Override
    protected String describe(Section section) {
        return "Section{id=" + section.getSectionId() + ", courseId="
                + section.getCourseId() + ", title='" + section.getTitle()
                + "', order=" + section.getOrderNumber() + "}";
    }
}
