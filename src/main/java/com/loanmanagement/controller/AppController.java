package com.loanmanagement.controller;

import com.loanmanagement.model.Loan;
import com.loanmanagement.service.LoanService;
import com.loanmanagement.service.impl.LoanServiceImpl;
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
    }
}