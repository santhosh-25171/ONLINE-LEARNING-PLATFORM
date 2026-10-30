package com.learning.CLI;

import com.learning.models.Enrollment;
import com.learning.services.EnrollmentService;
import java.time.LocalDate;
import java.util.Scanner;

public final class EnrollmentCLI extends CrudMenu<Enrollment> {
    public EnrollmentCLI(EnrollmentService service) {
        super("Enrollments", service);
    }

    @Override
    protected Enrollment readEntity(Scanner input) {
        int id = CliInput.readInt(input, "Enrollment ID: ");
        int studentId = CliInput.readInt(input, "Student user ID: ");
        int courseId = CliInput.readInt(input, "Course ID: ");
        String status = CliInput.readLine(input, "Status: ");
        double progress = CliInput.readDouble(input, "Progress percentage: ");
        LocalDate enrollmentDate = CliInput.readDate(input,
                "Enrollment date (YYYY-MM-DD, blank=today): ", true, LocalDate.now());
        LocalDate completionDate = CliInput.readDate(input,
                "Completion date (YYYY-MM-DD, blank=none): ", true, null);
        return new Enrollment(id, studentId, courseId, status, progress,
                enrollmentDate, completionDate);
    }

    @Override
    protected String describe(Enrollment enrollment) {
        return "Enrollment{id=" + enrollment.getEnrollmentId() + ", studentId="
                + enrollment.getStudentId() + ", courseId=" + enrollment.getCourseId()
                + ", status='" + enrollment.getStatus() + "', progress="
                + enrollment.getProgressPercentage() + ", enrolled="
                + enrollment.getEnrollmentDate() + ", completed="
                + enrollment.getCompletionDate() + "}";
    }
}
