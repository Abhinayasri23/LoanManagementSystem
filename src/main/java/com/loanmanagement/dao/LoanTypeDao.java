package com.loanmanagement.dao;

import com.loanmanagement.model.LoanType;

public interface LoanTypeDao {
    void addLoanType(LoanType loanType);

    LoanType getLoanTypeById(int loanTypeId);

    void updateLoanType(LoanType loanType);

    void deleteLoanType(int loanTypeId);
}
