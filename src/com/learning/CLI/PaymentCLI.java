package com.learning.CLI;

import com.learning.models.Payment;
import com.learning.services.PaymentService;
import java.util.Scanner;

public final class PaymentCLI extends CrudMenu<Payment> {
    public PaymentCLI(PaymentService service) {
        super("Payments", service);
    }

    @Override
    protected Payment readEntity(Scanner input) {
        return new Payment(CliInput.readInt(input, "Payment ID: "),
                CliInput.readInt(input, "Enrollment ID: "),
                CliInput.readDouble(input, "Amount: "),
                CliInput.readLine(input, "Payment method: "),
                CliInput.readLine(input, "Payment status: "),
                CliInput.readDate(input, "Payment date (YYYY-MM-DD): ", false, null));
    }

    @Override
    protected String describe(Payment payment) {
        return "Payment{id=" + payment.getPaymentId() + ", enrollmentId="
                + payment.getEnrollmentId() + ", amount=" + payment.getAmount()
                + ", method='" + payment.getPaymentMethod() + "', status='"
                + payment.getPaymentStatus() + "', date=" + payment.getPaymentDate() + "}";
    }
}
