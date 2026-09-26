package com.loanmanagement.controller;

import com.loanmanagement.model.Loan;
import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.model.LoanType;
import com.loanmanagement.model.Repayment;
import com.loanmanagement.model.User;

import com.loanmanagement.service.ApplicationService;
import com.loanmanagement.service.LoanService;
import com.loanmanagement.service.LoanTypeService;
import com.loanmanagement.service.RepaymentService;
import com.loanmanagement.service.UserService;

import com.loanmanagement.service.impl.ApplicationServiceImpl;
import com.loanmanagement.service.impl.LoanServiceImpl;
import com.loanmanagement.service.impl.LoanTypeServiceImpl;
import com.loanmanagement.service.impl.RepaymentServiceImpl;
import com.loanmanagement.service.impl.UserServiceImpl;

import com.loanmanagement.util.DBConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class AppController {

    private static final Logger logger =
            LoggerFactory.getLogger(AppController.class);

    public static void main(String[] args) {

        // Testing database connection
        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            logger.info("Connection test successful!");
        } else {
            logger.error("Connection test failed!");
            return;
        }

        // Creating Loan Service object
        LoanService loanService = new LoanServiceImpl();

        // Get existing loan
        Loan loan = loanService.getLoanById(1);

        if (loan != null) {

            logger.info("Loan fetched successfully!");

            // Update loan details
            loan.setPrincipalAmount(120000);
            loan.setInterestRate(11.0);
            loan.setTenureMonths(24);

            loanService.updateLoan(loan);

            logger.info("Loan update completed!");

        } else {
            logger.warn("Loan not found!");
        }

        // Creating Application Service object
        ApplicationService applicationService =
                new ApplicationServiceImpl();

        // Get existing loan application
        LoanApplication application =
                applicationService.getApplicationById(1);

        if (application != null) {

            logger.info("Loan application fetched successfully!");

            // Update application remarks
            application.setRemarks("Application updated");

            applicationService.updateApplication(application);

            logger.info("Loan application update completed!");

        } else {
            logger.warn("Loan application not found!");
        }

        // Creating LoanType Service object
        LoanTypeService loanTypeService =
                new LoanTypeServiceImpl();

        // Get existing loan type
        LoanType loanType =
                loanTypeService.getLoanTypeById(1);

        if (loanType != null) {

            logger.info("Loan type fetched successfully!");

            // Update loan type description
            loanType.setDescription("Updated loan type");

            loanTypeService.updateLoanType(loanType);

            logger.info("Loan type update completed!");

        } else {
            logger.warn("Loan type not found!");
        }

        // Creating Repayment Service object
        RepaymentService repaymentService =
                new RepaymentServiceImpl();

        // Get existing repayment
        Repayment repayment =
                repaymentService.getRepaymentById(1);

        if (repayment != null) {

            logger.info("Repayment fetched successfully!");

            // Update repayment remarks
            repayment.setRemarks("Updated repayment");

            repaymentService.updateRepayment(repayment);

            logger.info("Repayment update completed!");

        } else {
            logger.warn("Repayment not found!");
        }

        // Creating User Service object
        UserService userService =
                new UserServiceImpl();

        // Get existing user
        User user =
                userService.getUserById(1);

        if (user != null) {

            logger.info("User fetched successfully!");

            // Update user status
            user.setStatus("ACTIVE");

            userService.updateUser(user);

            logger.info("User update completed!");

        } else {
            logger.warn("User not found!");
        }
    }
}