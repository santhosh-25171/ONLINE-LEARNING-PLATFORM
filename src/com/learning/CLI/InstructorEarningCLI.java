package com.learning.CLI;

import com.learning.models.InstructorEarning;
import com.learning.services.InstructorEarningService;
import java.util.Scanner;

public final class InstructorEarningCLI extends CrudMenu<InstructorEarning> {
    public InstructorEarningCLI(InstructorEarningService service) {
        super("Instructor earnings", service);
    }

    @Override
    protected InstructorEarning readEntity(Scanner input) {
        return new InstructorEarning(CliInput.readInt(input, "Earning ID: "),
                CliInput.readInt(input, "Course ID: "),
                CliInput.readInt(input, "Enrollment ID: "),
                CliInput.readDouble(input, "Instructor share: "),
                CliInput.readDouble(input, "Platform share: "),
                CliInput.readLine(input, "Status: "));
    }

    @Override
    protected String describe(InstructorEarning earning) {
        return "InstructorEarning{id=" + earning.getEarningId() + ", courseId="
                + earning.getCourseId() + ", enrollmentId=" + earning.getEnrollmentId()
                + ", instructorShare=" + earning.getInstructorShare()
                + ", platformShare=" + earning.getPlatformShare() + ", status='"
                + earning.getStatus() + "'}";
    }
}
