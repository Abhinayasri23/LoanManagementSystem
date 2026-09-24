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

import java.sql.Connection;

public class AppController {

    public static void main(String[] args) {

        // Testing database connection
        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("Connection test successful!");
        } else {
            System.out.println("Connection test failed!");
            return;
        }

        // Creating Loan Service object
        LoanService loanService = new LoanServiceImpl();

        // Get existing loan
        Loan loan = loanService.getLoanById(1);

        if (loan != null) {

            System.out.println("Loan fetched successfully!");

            // Update loan details
            loan.setPrincipalAmount(120000);
            loan.setInterestRate(11.0);
            loan.setTenureMonths(24);

            loanService.updateLoan(loan);

            System.out.println("Loan update completed!");

        } else {
            System.out.println("Loan not found!");
        }

        // Creating Application Service object
        ApplicationService applicationService =
                new ApplicationServiceImpl();

        // Get existing loan application
        LoanApplication application =
                applicationService.getApplicationById(1);

        if (application != null) {

            System.out.println("Loan application fetched successfully!");

            // Update application remarks
            application.setRemarks("Application updated");

            applicationService.updateApplication(application);

            System.out.println("Loan application update completed!");

        } else {
            System.out.println("Loan application not found!");
        }

        // Creating LoanType Service object
        LoanTypeService loanTypeService =
                new LoanTypeServiceImpl();

        // Get existing loan type
        LoanType loanType =
                loanTypeService.getLoanTypeById(1);

        if (loanType != null) {

            System.out.println("Loan type fetched successfully!");

            // Update loan type description
            loanType.setDescription("Updated loan type");

            loanTypeService.updateLoanType(loanType);

            System.out.println("Loan type update completed!");

        } else {
            System.out.println("Loan type not found!");
        }

        // Creating Repayment Service object
        RepaymentService repaymentService =
                new RepaymentServiceImpl();

        // Get existing repayment
        Repayment repayment =
                repaymentService.getRepaymentById(1);

        if (repayment != null) {

            System.out.println("Repayment fetched successfully!");

            // Update repayment remarks
            repayment.setRemarks("Updated repayment");

            repaymentService.updateRepayment(repayment);

            System.out.println("Repayment update completed!");

        } else {
            System.out.println("Repayment not found!");
        }

        // Creating User Service object
        UserService userService =
                new UserServiceImpl();

        // Get existing user
        User user =
                userService.getUserById(1);

        if (user != null) {

            System.out.println("User fetched successfully!");

            // Update user status
            user.setStatus("ACTIVE");

            userService.updateUser(user);

            System.out.println("User update completed!");

        } else {
            System.out.println("User not found!");
        }
    }
}