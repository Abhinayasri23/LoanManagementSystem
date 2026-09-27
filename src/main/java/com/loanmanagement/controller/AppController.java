package com.loanmanagement.controller;

import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AuthController authController =
                new AuthController();

        CustomerController customerController =
                new CustomerController();

        LoanApplicationController applicationController =
                new LoanApplicationController();

        LoanController loanController =
                new LoanController();

        LoanTypeController loanTypeController =
                new LoanTypeController();

        UserController userController =
                new UserController();

        int choice;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("       LOAN MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Login");
            System.out.println("2. Customer Management");
            System.out.println("3. Loan Application");
            System.out.println("4. Loan Management");
            System.out.println("5. Loan Type Management");
            System.out.println("6. User Management");
            System.out.println("7. Exit");
            System.out.println("======================================");

            choice = InputUtil.readInt(
                    scanner,
                    "Enter your choice: "
            );

            switch (choice) {

                case 1:
                    authController.login();
                    break;

                case 2:
                    customerController.customerMenu();
                    break;

                case 3:
                    applicationController.applicationMenu();
                    break;

                case 4:
                    loanController.loanMenu();
                    break;

                case 5:
                    loanTypeController.loanTypeMenu();
                    break;

                case 6:
                    userController.userMenu();
                    break;

                case 7:
                    System.out.println();
                    System.out.println(
                            "Thank you for using Loan Management System!"
                    );
                    break;

                default:
                    System.out.println();
                    System.out.println(
                            "Invalid choice!"
                    );
                    System.out.println(
                            "Please enter a valid option."
                    );
            }

        } while (choice != 7);

        scanner.close();
    }
}