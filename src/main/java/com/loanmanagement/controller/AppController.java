package com.loanmanagement.controller;

import com.loanmanagement.model.Loan;
import com.loanmanagement.service.CustomerService;
import com.loanmanagement.service.impl.CustomerServiceImpl;
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

        // Creating Customer Service object
        CustomerService customerService = new CustomerServiceImpl();

        // Creating Loan Service object
        LoanService loanService = new LoanServiceImpl();

        // Creating Loan object
        Loan loan = new Loan();

        loan.setApplicationId(1);
        loan.setCustomerId(7);
        loan.setLoanTypeId(1);
        loan.setPrincipalAmount(100000);
        loan.setInterestRate(10.5);
        loan.setTenureMonths(24);
        loan.setTotalPayable(121000);
        loan.setOutstandingAmount(121000);
        loan.setStartDate("2026-09-22");
        loan.setStatus("ACTIVE");
        loan.setCreatedBy(1);

        // Add Loan
        loanService.addLoan(loan);

        System.out.println("Loan add completed!");
    }
}