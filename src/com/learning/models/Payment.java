package com.learning.models;

import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private int enrollmentId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate paymentDate;

    public Payment(int paymentId, int enrollmentId, double amount, String paymentMethod,
                   String paymentStatus, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.enrollmentId = enrollmentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() { return paymentId; }
    public int getEnrollmentId() { return enrollmentId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }
    public LocalDate getPaymentDate() { return paymentDate; }
}
