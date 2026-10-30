package com.learning.services;

import com.learning.models.Payment;
import com.learning.repository.EnrollmentRepository;
import com.learning.repository.PaymentRepository;

public class PaymentService extends CrudService<Payment> {
    private final EnrollmentRepository enrollments;

    public PaymentService(PaymentRepository payments, EnrollmentRepository enrollments) {
        super(payments);
        this.enrollments = enrollments;
    }

    @Override
    protected void validate(Payment payment) {
        require(payment != null, "Payment cannot be null");
        require(enrollments.findById(payment.getEnrollmentId()).isPresent(),
                "Enrollment does not exist");
        requireNonNegative(payment.getAmount(), "Amount");
        requireText(payment.getPaymentMethod(), "Payment method");
        requireText(payment.getPaymentStatus(), "Payment status");
        require(payment.getPaymentDate() != null, "Payment date is required");
    }
}
