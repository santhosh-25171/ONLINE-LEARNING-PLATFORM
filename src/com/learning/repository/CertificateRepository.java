package com.learning.repository;

import com.learning.models.Certificate;

public class CertificateRepository extends InMemoryRepository<Certificate> {
    public CertificateRepository() {
        super(Certificate::getCertificateId);
    }
}
