package com.example.jobspage.domain.exception;

import com.example.jobspage.domain.model.ids.CompanyId;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(CompanyId companyId) {
        super(String.format("Company with this %s id not found", companyId));
    }
}
