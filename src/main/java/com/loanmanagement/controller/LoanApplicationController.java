package com.loanmanagement.controller;

import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.service.ApplicationService;
import com.loanmanagement.service.impl.ApplicationServiceImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

public class LoanApplicationController {

    private ApplicationService applicationService =
            new ApplicationServiceImpl();


    // CUSTOMER MENU
    public void applicationMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("===== LOAN APPLICATION =====");
            System.out.println("1. Apply for Loan");
            System.out.println("2. View Application");
            System.out.println("3. Update Application");
            System.out.println("4. Delete Application");
            System.out.println("5. Back");

            int choice =
                    InputUtil.readInt(scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    addApplication(scanner);
                    break;

                case 2:
                    getApplication(scanner);
                    break;

                case 3:
                    updateApplication(scanner);
                    break;

                case 4:
                    deleteApplication(scanner);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    // ADD APPLICATION
    private void addApplication(Scanner scanner) {

        LoanApplication application =
                new LoanApplication();

        application.setCustomerId(
                InputUtil.readInt(scanner, "Enter Customer ID: "));

        application.setLoanTypeId(
                InputUtil.readInt(scanner, "Enter Loan Type ID: "));

        application.setRequestedAmount(
                InputUtil.readDouble(scanner, "Enter Amount: "));

        application.setTenureMonths(
                InputUtil.readInt(scanner, "Enter Tenure: "));

        application.setPurpose(
                InputUtil.readString(scanner, "Enter Purpose: "));

        application.setRemarks(
                InputUtil.readString(scanner, "Enter Remarks: "));

        application.setStatus("PENDING");

        try {

            applicationService.addApplication(application);

            System.out.println(
                    "Application submitted successfully!");

            System.out.println(
                    "Status: PENDING");

        } catch (RuntimeException e) {

            System.out.println(
                    "Application failed!");

        }
    }


    // VIEW APPLICATION
    private void getApplication(Scanner scanner) {

        int id =
                InputUtil.readInt(
                        scanner,
                        "Enter Application ID: ");

        try {

            LoanApplication application =
                    applicationService.getApplicationById(id);

            System.out.println();
            System.out.println("Application ID : "
                    + application.getApplicationId());

            System.out.println("Customer ID    : "
                    + application.getCustomerId());

            System.out.println("Loan Type ID   : "
                    + application.getLoanTypeId());

            System.out.println("Amount         : "
                    + application.getRequestedAmount());

            System.out.println("Tenure         : "
                    + application.getTenureMonths());

            System.out.println("Purpose        : "
                    + application.getPurpose());

            System.out.println("Status         : "
                    + application.getStatus());

            System.out.println("Remarks        : "
                    + application.getRemarks());

        } catch (NotFoundException e) {

            System.out.println(
                    "Application not found!");
        }
    }


    // UPDATE APPLICATION
    private void updateApplication(Scanner scanner) {

        int id =
                InputUtil.readInt(
                        scanner,
                        "Enter Application ID: ");

        try {

            LoanApplication application =
                    applicationService.getApplicationById(id);

            System.out.println("1. Customer ID");
            System.out.println("2. Loan Type ID");
            System.out.println("3. Amount");
            System.out.println("4. Tenure");
            System.out.println("5. Purpose");
            System.out.println("6. Remarks");

            int choice =
                    InputUtil.readInt(
                            scanner,
                            "Enter choice: ");

            switch (choice) {

                case 1:
                    application.setCustomerId(
                            InputUtil.readInt(
                                    scanner,
                                    "New Customer ID: "));
                    break;

                case 2:
                    application.setLoanTypeId(
                            InputUtil.readInt(
                                    scanner,
                                    "New Loan Type ID: "));
                    break;

                case 3:
                    application.setRequestedAmount(
                            InputUtil.readDouble(
                                    scanner,
                                    "New Amount: "));
                    break;

                case 4:
                    application.setTenureMonths(
                            InputUtil.readInt(
                                    scanner,
                                    "New Tenure: "));
                    break;

                case 5:
                    application.setPurpose(
                            InputUtil.readString(
                                    scanner,
                                    "New Purpose: "));
                    break;

                case 6:
                    application.setRemarks(
                            InputUtil.readString(
                                    scanner,
                                    "New Remarks: "));
                    break;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            applicationService.updateApplication(application);

            System.out.println(
                    "Application updated successfully!");

        } catch (RuntimeException e) {

            System.out.println(
                    "Update failed!");
        }
    }


    // DELETE APPLICATION
    private void deleteApplication(Scanner scanner) {

        int id =
                InputUtil.readInt(
                        scanner,
                        "Enter Application ID: ");

        try {

            applicationService.getApplicationById(id);

            String answer =
                    InputUtil.readString(
                            scanner,
                            "Delete? yes/no: ");

            if (answer.equalsIgnoreCase("yes")) {

                applicationService.deleteApplication(id);

                System.out.println(
                        "Application deleted successfully!");

            } else {

                System.out.println(
                        "Delete cancelled!");
            }

        } catch (NotFoundException e) {

            System.out.println(
                    "Application not found!");
        }
    }


    // LOAN OFFICER MENU
    public void officerApplicationMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("===== LOAN OFFICER =====");
            System.out.println("1. View Application");
            System.out.println("2. Approve Application");
            System.out.println("3. Reject Application");
            System.out.println("4. Back");

            int choice =
                    InputUtil.readInt(scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    getApplication(scanner);
                    break;

                case 2:
                    changeStatus(scanner, "APPROVED");
                    break;

                case 3:
                    changeStatus(scanner, "REJECTED");
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    // CHANGE APPLICATION STATUS
    private void changeStatus(
            Scanner scanner,
            String status) {

        int id =
                InputUtil.readInt(
                        scanner,
                        "Enter Application ID: ");

        try {

            if (status.equals("APPROVED")) {

                applicationService.approveApplication(id);

                System.out.println(
                        "Application approved!");

            } else {

                applicationService.rejectApplication(id);

                System.out.println(
                        "Application rejected!");
            }

        } catch (RuntimeException e) {

            System.out.println(
                    "Operation failed!");
            System.out.println(
                    e.getMessage());
        }
    }
}