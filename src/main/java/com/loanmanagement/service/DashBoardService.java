package com.loanmanagement.service;

public interface DashBoardService {
    int getTotalCustomers();

    int getTotalLoans();

    double getTotalLoanAmount();

    double getTotalRepaymentAmount();
}
