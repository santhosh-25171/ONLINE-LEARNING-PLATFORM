package com.learning.CLI;

import com.learning.services.LearningPlatformServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            run(input, new LearningPlatformServices());
        } catch (CliInput.EndOfInputException exception) {
            System.out.println("\nInput closed. Exiting.");
        }
    }

    private static void run(Scanner input, LearningPlatformServices services) {
        List<CrudMenu<?>> menus = createMenus(services);
        while (true) {
            System.out.println("\n=== Online Learning Platform ===");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getLabel());
            }
            System.out.println("0. Exit");
            int choice = CliInput.readChoice(input, "Choose a service: ", 0, menus.size());
            if (choice == 0) {
                return;
            }
            menus.get(choice - 1).run(input);
        }
    }

    private static List<CrudMenu<?>> createMenus(LearningPlatformServices services) {
        List<CrudMenu<?>> menus = new ArrayList<CrudMenu<?>>();
        menus.add(new UserCLI(services.getUserService()));
        menus.add(new CourseCLI(services.getCourseService()));
        menus.add(new EnrollmentCLI(services.getEnrollmentService()));
        menus.add(new SectionCLI(services.getSectionService()));
        menus.add(new LessonCLI(services.getLessonService()));
        menus.add(new PaymentCLI(services.getPaymentService()));
        menus.add(new ReviewCLI(services.getReviewService()));
        menus.add(new CertificateCLI(services.getCertificateService()));
        menus.add(new InstructorEarningCLI(services.getInstructorEarningService()));
        menus.add(new LessonProgressCLI(services.getLessonProgressService()));
        menus.add(new QuizAttemptCLI(services.getQuizAttemptService()));
        return menus;
    }
}
