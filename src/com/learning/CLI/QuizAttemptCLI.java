package com.learning.CLI;

import com.learning.models.QuizAttempt;
import com.learning.services.QuizAttemptService;
import java.util.Scanner;

public final class QuizAttemptCLI extends CrudMenu<QuizAttempt> {
    public QuizAttemptCLI(QuizAttemptService service) {
        super("Quiz attempts", service);
    }

    @Override
    protected QuizAttempt readEntity(Scanner input) {
        return new QuizAttempt(CliInput.readInt(input, "Attempt ID: "),
                CliInput.readInt(input, "Enrollment ID: "),
                CliInput.readInt(input, "Lesson ID: "),
                CliInput.readInt(input, "Score: "),
                CliInput.readBoolean(input, "Passed (yes/no): "),
                CliInput.readDate(input, "Attempt date (YYYY-MM-DD): ", false, null));
    }

    @Override
    protected String describe(QuizAttempt attempt) {
        return "QuizAttempt{id=" + attempt.getAttemptId() + ", enrollmentId="
                + attempt.getEnrollmentId() + ", lessonId=" + attempt.getLessonId()
                + ", score=" + attempt.getScore() + ", passed=" + attempt.isPassed()
                + ", date=" + attempt.getAttemptDate() + "}";
    }
}
