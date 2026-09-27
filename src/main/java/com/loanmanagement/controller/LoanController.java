package com.loanmanagement.controller;

import com.loanmanagement.model.Loan;
import com.loanmanagement.service.LoanService;
import com.loanmanagement.service.impl.LoanServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanController {

    private static final Logger logger =
            LoggerFactory.getLogger(LoanController.class);

    private LoanService loanService =
            new LoanServiceImpl();

    // Get Loan
    public void getLoan(int loanId) {

        Loan loan =
                loanService.getLoanById(loanId);

        logger.info("Loan fetched successfully!");
        logger.info("Loan ID: {}", loan.getLoanId());
    }

    // Update Loan
    public void updateLoan(Loan loan) {

        loanService.updateLoan(loan);

        logger.info("Loan update completed!");
    }

    // Test
    public static void main(String[] args) {

        LoanController loanController =
                new LoanController();

        // Get existing loan
        loanController.getLoan(1);
    }
}