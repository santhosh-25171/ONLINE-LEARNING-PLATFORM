package com.learning.CLI;

import com.learning.models.Certificate;
import com.learning.services.CertificateService;
import java.util.Scanner;

public final class CertificateCLI extends CrudMenu<Certificate> {
    public CertificateCLI(CertificateService service) {
        super("Certificates", service);
    }

    @Override
    protected Certificate readEntity(Scanner input) {
        return new Certificate(CliInput.readInt(input, "Certificate ID: "),
                CliInput.readInt(input, "Enrollment ID: "),
                CliInput.readLine(input, "Unique certificate ID: "),
                CliInput.readDate(input, "Issued date (YYYY-MM-DD): ", false, null));
    }

    @Override
    protected String describe(Certificate certificate) {
        return "Certificate{id=" + certificate.getCertificateId() + ", enrollmentId="
                + certificate.getEnrollmentId() + ", uniqueId='"
                + certificate.getUniqueCertificateId() + "', issued="
                + certificate.getIssuedDate() + "}";
    }
}
