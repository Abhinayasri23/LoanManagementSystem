package com.loanmanagement.dao;

import com.loanmanagement.model.Loan;

public interface LoanDao {
    void addLoan(Loan loan);

    Loan getLoanById(int loanId);

    void updateLoan(Loan loan);

    void deleteLoan(int loanId);
}
