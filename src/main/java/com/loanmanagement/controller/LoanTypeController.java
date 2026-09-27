package com.loanmanagement.controller;

import com.loanmanagement.model.LoanType;
import com.loanmanagement.service.LoanTypeService;
import com.loanmanagement.service.impl.LoanTypeServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanTypeController {

    private static final Logger logger =
            LoggerFactory.getLogger(LoanTypeController.class);

    private LoanTypeService loanTypeService =
            new LoanTypeServiceImpl();

    // Get Loan Type
    public void getLoanType(int loanTypeId) {

        LoanType loanType =
                loanTypeService.getLoanTypeById(loanTypeId);

        logger.info("Loan type fetched successfully!");
        logger.info("Loan Type ID: {}",
                loanType.getLoanTypeId());
    }

    // Update Loan Type
    public void updateLoanType(LoanType loanType) {

        loanTypeService.updateLoanType(loanType);

        logger.info("Loan type update completed!");
    }

    // Test
    public static void main(String[] args) {

        LoanTypeController controller =
                new LoanTypeController();

        controller.getLoanType(1);
    }
}
