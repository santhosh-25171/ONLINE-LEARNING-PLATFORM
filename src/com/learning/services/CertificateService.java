package com.learning.services;

import com.learning.models.Certificate;
import com.learning.repository.CertificateRepository;
import com.learning.repository.EnrollmentRepository;

public class CertificateService extends CrudService<Certificate> {
    private final EnrollmentRepository enrollments;

    public CertificateService(CertificateRepository certificates,
                              EnrollmentRepository enrollments) {
        super(certificates);
        this.enrollments = enrollments;
    }

    @Override
    protected void validate(Certificate certificate) {
        require(certificate != null, "Certificate cannot be null");
        require(enrollments.findById(certificate.getEnrollmentId()).isPresent(),
                "Enrollment does not exist");
        requireText(certificate.getUniqueCertificateId(), "Unique certificate id");
        require(certificate.getIssuedDate() != null, "Issued date is required");
    }
}
