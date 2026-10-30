package com.learning.CLI;

import com.learning.models.Course;
import com.learning.services.CourseService;
import java.util.Scanner;

public final class CourseCLI extends CrudMenu<Course> {
    public CourseCLI(CourseService service) {
        super("Courses", service);
    }

    @Override
    protected Course readEntity(Scanner input) {
        int id = CliInput.readInt(input, "Course ID: ");
        int instructorId = CliInput.readInt(input, "Instructor user ID: ");
        String title = CliInput.readLine(input, "Title: ");
        String description = CliInput.readLine(input, "Description: ");
        String category = CliInput.readLine(input, "Category: ");
        String level = CliInput.readLine(input, "Level: ");
        double price = CliInput.readDouble(input, "Price: ");
        String status = CliInput.readLine(input, "Status: ");
        double averageRating = CliInput.readDouble(input, "Average rating: ");
        return new Course(id, instructorId, title, description, category, level,
                price, status, averageRating);
    }

    @Override
    protected String describe(Course course) {
        return "Course{id=" + course.getCourseId() + ", instructorId="
                + course.getInstructorId() + ", title='" + course.getTitle()
                + "', category='" + course.getCategory() + "', level='"
                + course.getLevel() + "', price=" + course.getPrice()
                + ", status='" + course.getStatus() + "', averageRating="
                + course.getAverageRating() + "}";
    }
}
