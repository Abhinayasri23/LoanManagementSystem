package com.loanmanagement.service.impl;

import com.loanmanagement.service.CreditBureauService;

public class CreditBureauServiceImpl implements CreditBureauService {
    @Override
    public int getCreditScore(int customerId) {
        return 0;
    }

    @Override
    public boolean isEligible(int customerId) {
        return false;
    }
}
