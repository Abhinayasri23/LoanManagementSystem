package com.loanmanagement.controller;

import com.loanmanagement.model.Loan;
import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.service.LoanService;
import com.loanmanagement.service.ApplicationService;
import com.loanmanagement.service.impl.LoanServiceImpl;
import com.loanmanagement.service.impl.ApplicationServiceImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

public class LoanController {

    private LoanService loanService =
            new LoanServiceImpl();

    private ApplicationService applicationService =
            new ApplicationServiceImpl();


    // CREATE LOAN MENU
    public void createLoanMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("========== CREATE LOAN ==========");

        createLoan(scanner);
    }


    // LOAN MANAGEMENT MENU
    public void loanMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("========== LOAN MANAGEMENT ==========");
            System.out.println("1. View Loan");
            System.out.println("2. Update Loan");
            System.out.println("3. Delete Loan");
            System.out.println("4. Back");

            int choice =
                    InputUtil.readInt(
                            scanner,
                            "Enter choice: ");

            if (choice == 1) {

                viewLoan(scanner);

            } else if (choice == 2) {

                updateLoan(scanner);

            } else if (choice == 3) {

                deleteLoan(scanner);

            } else if (choice == 4) {

                return;

            } else {

                System.out.println("Invalid choice!");
            }
        }
    }


    // CREATE LOAN
    private void createLoan(Scanner scanner) {

        int applicationId =
                InputUtil.readInt(
                        scanner,
                        "Enter Approved Application ID: ");

        try {

            LoanApplication application =
                    applicationService.getApplicationById(
                            applicationId);

            if (!"APPROVED".equalsIgnoreCase(
                    application.getStatus())) {

                System.out.println();
                System.out.println(
                        "Loan cannot be created!");
                System.out.println(
                        "Application is not approved.");
                System.out.println(
                        "Status: "
                                + application.getStatus());

                return;
            }

            Loan loan = new Loan();

            loan.setApplicationId(applicationId);

            loan.setCustomerId(
                    application.getCustomerId());

            loan.setLoanTypeId(
                    application.getLoanTypeId());

            loan.setPrincipalAmount(
                    application.getRequestedAmount());

            loan.setTenureMonths(
                    application.getTenureMonths());

            loan.setInterestRate(
                    InputUtil.readDouble(
                            scanner,
                            "Enter Interest Rate: "));

            loan.setCreatedBy(
                    InputUtil.readInt(
                            scanner,
                            "Enter Officer User ID: "));

            loan.setStatus("ACTIVE");

            loanService.addLoan(loan);

            System.out.println();
            System.out.println(
                    "Loan created successfully!");
            System.out.println(
                    "Loan Status: ACTIVE");

        } catch (NotFoundException e) {

            System.out.println(
                    "Application not found!");

        } catch (RuntimeException e) {

            System.out.println(
                    "Loan creation failed!");
            System.out.println(
                    e.getMessage());
        }
    }


    // VIEW LOAN
    private void viewLoan(Scanner scanner) {

        int loanId =
                InputUtil.readInt(
                        scanner,
                        "Enter Loan ID: ");

        try {

            Loan loan =
                    loanService.getLoanById(loanId);

            System.out.println();
            System.out.println("========== LOAN ==========");
            System.out.println(
                    "Loan ID: " + loan.getLoanId());
            System.out.println(
                    "Application ID: "
                            + loan.getApplicationId());
            System.out.println(
                    "Customer ID: "
                            + loan.getCustomerId());
            System.out.println(
                    "Amount: "
                            + loan.getPrincipalAmount());
            System.out.println(
                    "Interest: "
                            + loan.getInterestRate());
            System.out.println(
                    "Tenure: "
                            + loan.getTenureMonths());
            System.out.println(
                    "Status: "
                            + loan.getStatus());

        } catch (NotFoundException e) {

            System.out.println(
                    "Loan not found!");
        }
    }


    // UPDATE LOAN
    private void updateLoan(Scanner scanner) {

        int loanId =
                InputUtil.readInt(
                        scanner,
                        "Enter Loan ID: ");

        try {

            Loan loan =
                    loanService.getLoanById(loanId);

            loan.setStatus(
                    InputUtil.readString(
                            scanner,
                            "Enter New Status: "));

            loanService.updateLoan(loan);

            System.out.println(
                    "Loan updated successfully!");

        } catch (RuntimeException e) {

            System.out.println(
                    "Loan update failed!");
        }
    }


    // DELETE LOAN
    private void deleteLoan(Scanner scanner) {

        int loanId =
                InputUtil.readInt(
                        scanner,
                        "Enter Loan ID: ");

        try {

            loanService.deleteLoan(loanId);

            System.out.println(
                    "Loan deleted successfully!");

        } catch (RuntimeException e) {

            System.out.println();
            System.out.println(
                    "Loan cannot be deleted because repayment records exist for this loan.");
        }
    }
}