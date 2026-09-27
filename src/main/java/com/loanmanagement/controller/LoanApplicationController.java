package com.loanmanagement.controller;

import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.service.ApplicationService;
import com.loanmanagement.service.impl.ApplicationServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanApplicationController {

    private static final Logger logger =
            LoggerFactory.getLogger(LoanApplicationController.class);

    private ApplicationService applicationService =
            new ApplicationServiceImpl();

    // Get Loan Application
    public void getApplication(int applicationId) {

        LoanApplication application =
                applicationService.getApplicationById(applicationId);

        logger.info("Loan application fetched successfully!");
        logger.info("Application ID: {}",
                application.getApplicationId());
    }

    // Update Loan Application
    public void updateApplication(
            LoanApplication application) {

        applicationService.updateApplication(application);

        logger.info("Loan application update completed!");
    }

    // Test
    public static void main(String[] args) {

        LoanApplicationController controller =
                new LoanApplicationController();

        // Get existing application
        controller.getApplication(1);
    }
}