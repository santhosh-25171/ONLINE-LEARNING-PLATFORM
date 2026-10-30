package com.learning.services;

import com.learning.repository.CertificateRepository;
import com.learning.repository.CourseRepository;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.InstructorEarningRepository;
import com.learning.repository.LessonProgressRepository;
import com.learning.repository.LessonRepository;
import com.learning.repository.PaymentRepository;
import com.learning.repository.QuizAttemptRepository;
import com.learning.repository.ReviewRepository;
import com.learning.repository.SectionRepository;
import com.learning.repository.UserRepository;

public class LearningPlatformServices {
    private final UserService userService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final SectionService sectionService;
    private final LessonService lessonService;
    private final PaymentService paymentService;
    private final ReviewService reviewService;
    private final CertificateService certificateService;
    private final InstructorEarningService instructorEarningService;
    private final LessonProgressService lessonProgressService;
    private final QuizAttemptService quizAttemptService;

    public LearningPlatformServices() {
        UserRepository users = new UserRepository();
        CourseRepository courses = new CourseRepository();
        EnrollmentRepository enrollments = new EnrollmentRepository();
        SectionRepository sections = new SectionRepository();
        LessonRepository lessons = new LessonRepository();

        userService = new UserService(users);
        courseService = new CourseService(courses, users);
        enrollmentService = new EnrollmentService(enrollments, users, courses);
        sectionService = new SectionService(sections, courses);
        lessonService = new LessonService(lessons, sections);
        paymentService = new PaymentService(new PaymentRepository(), enrollments);
        reviewService = new ReviewService(new ReviewRepository(), enrollments);
        certificateService = new CertificateService(new CertificateRepository(), enrollments);
        instructorEarningService = new InstructorEarningService(
                new InstructorEarningRepository(), courses, enrollments);
        lessonProgressService = new LessonProgressService(
                new LessonProgressRepository(), enrollments, lessons, sections);
        quizAttemptService = new QuizAttemptService(
                new QuizAttemptRepository(), enrollments, lessons, sections);
    }

    public UserService getUserService() { return userService; }
    public CourseService getCourseService() { return courseService; }
    public EnrollmentService getEnrollmentService() { return enrollmentService; }
    public SectionService getSectionService() { return sectionService; }
    public LessonService getLessonService() { return lessonService; }
    public PaymentService getPaymentService() { return paymentService; }
    public ReviewService getReviewService() { return reviewService; }
    public CertificateService getCertificateService() { return certificateService; }
    public InstructorEarningService getInstructorEarningService() {
        return instructorEarningService;
    }
    public LessonProgressService getLessonProgressService() { return lessonProgressService; }
    public QuizAttemptService getQuizAttemptService() { return quizAttemptService; }
}
