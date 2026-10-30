package com.learning.CLI;

import com.learning.models.LessonProgress;
import com.learning.services.LessonProgressService;
import java.util.Scanner;

public final class LessonProgressCLI extends CrudMenu<LessonProgress> {
    public LessonProgressCLI(LessonProgressService service) {
        super("Lesson progress", service);
    }

    @Override
    protected LessonProgress readEntity(Scanner input) {
        return new LessonProgress(CliInput.readInt(input, "Progress ID: "),
                CliInput.readInt(input, "Enrollment ID: "),
                CliInput.readInt(input, "Lesson ID: "),
                CliInput.readBoolean(input, "Completed (yes/no): "),
                CliInput.readDouble(input, "Watched percentage: "),
                CliInput.readDate(input,
                        "Completed date (YYYY-MM-DD, blank=none): ", true, null));
    }

    @Override
    protected String describe(LessonProgress progress) {
        return "LessonProgress{id=" + progress.getProgressId() + ", enrollmentId="
                + progress.getEnrollmentId() + ", lessonId=" + progress.getLessonId()
                + ", completed=" + progress.isCompleted() + ", watched="
                + progress.getWatchedPercentage() + ", completedDate="
                + progress.getCompletedDate() + "}";
    }
}
