package com.learning.models;

import java.time.LocalDate;

public class Certificate {
    private int certificateId;
    private int enrollmentId;
    private String uniqueCertificateId;
    private LocalDate issuedDate;

    public Certificate(int certificateId, int enrollmentId, String uniqueCertificateId,
                       LocalDate issuedDate) {
        this.certificateId = certificateId;
        this.enrollmentId = enrollmentId;
        this.uniqueCertificateId = uniqueCertificateId;
        this.issuedDate = issuedDate;
    }

    public int getCertificateId() { return certificateId; }
    public int getEnrollmentId() { return enrollmentId; }
    public String getUniqueCertificateId() { return uniqueCertificateId; }
    public LocalDate getIssuedDate() { return issuedDate; }
}
