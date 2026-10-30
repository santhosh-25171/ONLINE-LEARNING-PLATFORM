package com.learning.repository;

import com.learning.models.Payment;

public class PaymentRepository extends InMemoryRepository<Payment> {
    public PaymentRepository() {
        super(Payment::getPaymentId);
    }
}
