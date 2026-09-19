package com.loanmanagement.service;

public interface CreditBureauService {
    int getCreditScore(int customerId);

    boolean isEligible(int customerId);
}
