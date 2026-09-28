package com.loanmanagement.controller;

import com.loanmanagement.model.User;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AuthController authController = new AuthController();
        CustomerController customerController = new CustomerController();
        LoanApplicationController applicationController =
                new LoanApplicationController();
        LoanController loanController = new LoanController();
        LoanTypeController loanTypeController = new LoanTypeController();
        UserController userController = new UserController();

        while (true) {

            System.out.println();
            System.out.println("===== LOAN MANAGEMENT SYSTEM =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            int choice = InputUtil.readInt(
                    scanner, "Enter choice: ");

            if (choice == 1) {

                User user = authController.login();

                if (user == null) {
                    continue;
                }

                System.out.println();
                System.out.println("Welcome, " + user.getUsername());
                System.out.println("Role: " + user.getRole());


                // CUSTOMER
                if (user.getRole()
                        .equalsIgnoreCase("CUSTOMER")) {

                    while (true) {

                        System.out.println();
                        System.out.println("===== CUSTOMER MENU =====");
                        System.out.println("1. Customer Management");
                        System.out.println("2. Loan Application");
                        System.out.println("3. Loan Management");
                        System.out.println("4. Logout");

                        int option = InputUtil.readInt(
                                scanner, "Enter choice: ");

                        if (option == 1) {

                            customerController.customerMenu();

                        } else if (option == 2) {

                            applicationController.applicationMenu();

                        } else if (option == 3) {

                            loanController.loanMenu();

                        } else if (option == 4) {

                            System.out.println("Logged out!");
                            break;

                        } else {

                            System.out.println("Invalid choice!");
                        }
                    }
                }

                // LOAN OFFICER
                else if (user.getRole()
                        .equalsIgnoreCase("LOAN_OFFICER")) {
                    while (true) {
                        System.out.println();
                        System.out.println(
                                "===== LOAN OFFICER MENU =====");
                        System.out.println(
                                "1. Loan Applications");
                        System.out.println(
                                "2. Create Loan");
                        System.out.println(
                                "3. Loan Management");
                        System.out.println(
                                "4. Logout");
                        int option = InputUtil.readInt(
                                scanner, "Enter choice: ");
                        if (option == 1) {

                            applicationController
                                    .officerApplicationMenu();

                        } else if (option == 2) {

                            loanController.createLoanMenu();

                        } else if (option == 3) {

                            loanController.loanMenu();

                        } else if (option == 4) {

                            System.out.println("Logged out!");
                            break;

                        } else {

                            System.out.println("Invalid choice!");
                        }
                    }
                }
                // ADMIN
                else if (user.getRole()
                        .equalsIgnoreCase("ADMIN")) {

                    while (true) {

                        System.out.println();
                        System.out.println("===== ADMIN MENU =====");
                        System.out.println("1. User Management");
                        System.out.println("2. Customer Management");
                        System.out.println("3. Loan Application");
                        System.out.println("4. Loan Management");
                        System.out.println("5. Loan Type Management");
                        System.out.println("6. Logout");

                        int option = InputUtil.readInt(
                                scanner, "Enter choice: ");

                        if (option == 1) {

                            userController.userMenu();

                        } else if (option == 2) {

                            customerController.customerMenu();

                        } else if (option == 3) {

                            applicationController.applicationMenu();

                        } else if (option == 4) {

                            loanController.loanMenu();

                        } else if (option == 5) {

                            loanTypeController.loanTypeMenu();

                        } else if (option == 6) {

                            System.out.println("Logged out!");
                            break;

                        } else {

                            System.out.println("Invalid choice!");
                        }
                    }
                }

                else {

                    System.out.println("Unknown role!");
                }

            } else if (choice == 2) {

                System.out.println(
                        "Thank you for using Loan Management System!");
                break;

            } else {

                System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}