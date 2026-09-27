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


    // ADD

    private void addApplication(Scanner scanner) {

        LoanApplication application =
                new LoanApplication();

        application.setCustomerId(
                InputUtil.readInt(scanner,
                        "Enter Customer ID: "));

        application.setLoanTypeId(
                InputUtil.readInt(scanner,
                        "Enter Loan Type ID: "));

        application.setRequestedAmount(
                InputUtil.readDouble(scanner,
                        "Enter Requested Amount: "));

        application.setTenureMonths(
                InputUtil.readInt(scanner,
                        "Enter Tenure (months): "));

        application.setPurpose(
                InputUtil.readString(scanner,
                        "Enter Purpose: "));

        application.setRemarks(
                InputUtil.readString(scanner,
                        "Enter Remarks: "));

        try {

            applicationService.addApplication(application);

            System.out.println(
                    "Loan application added successfully!");

        } catch (RuntimeException e) {

            System.out.println(
                    "Invalid application details!");
            System.out.println(
                    "Please try again.");
        }
    }


    // VIEW

    private void getApplication(Scanner scanner) {

        while (true) {

            int id =
                    InputUtil.readInt(scanner,
                            "Enter Application ID: ");

            try {

                LoanApplication application =
                        applicationService
                                .getApplicationById(id);

                System.out.println();
                System.out.println("===== APPLICATION DETAILS =====");
                System.out.println(
                        "Application ID : "
                                + application.getApplicationId());
                System.out.println(
                        "Customer ID    : "
                                + application.getCustomerId());
                System.out.println(
                        "Loan Type ID   : "
                                + application.getLoanTypeId());
                System.out.println(
                        "Amount         : "
                                + application.getRequestedAmount());
                System.out.println(
                        "Tenure         : "
                                + application.getTenureMonths());
                System.out.println(
                        "Purpose        : "
                                + application.getPurpose());
                System.out.println(
                        "Status         : "
                                + application.getStatus());
                System.out.println(
                        "Remarks        : "
                                + application.getRemarks());

                break;

            } catch (NotFoundException e) {

                System.out.println(
                        "Application not found!");
                System.out.println(
                        "Please enter a valid Application ID.");
            }
        }
    }


    // UPDATE

    private void updateApplication(Scanner scanner) {

        while (true) {

            int id =
                    InputUtil.readInt(scanner,
                            "Enter Application ID: ");

            try {

                LoanApplication application =
                        applicationService
                                .getApplicationById(id);

                System.out.println();
                System.out.println("1. Customer ID");
                System.out.println("2. Loan Type ID");
                System.out.println("3. Requested Amount");
                System.out.println("4. Tenure");
                System.out.println("5. Purpose");
                System.out.println("6. Status");
                System.out.println("7. Remarks");

                int choice =
                        InputUtil.readInt(scanner,
                                "Enter field choice: ");

                switch (choice) {

                    case 1:
                        application.setCustomerId(
                                InputUtil.readInt(scanner,
                                        "New Customer ID: "));
                        break;

                    case 2:
                        application.setLoanTypeId(
                                InputUtil.readInt(scanner,
                                        "New Loan Type ID: "));
                        break;

                    case 3:
                        application.setRequestedAmount(
                                InputUtil.readDouble(scanner,
                                        "New Amount: "));
                        break;

                    case 4:
                        application.setTenureMonths(
                                InputUtil.readInt(scanner,
                                        "New Tenure: "));
                        break;

                    case 5:
                        application.setPurpose(
                                InputUtil.readString(scanner,
                                        "New Purpose: "));
                        break;

                    case 6:
                        application.setStatus(
                                InputUtil.readString(scanner,
                                        "New Status: "));
                        break;

                    case 7:
                        application.setRemarks(
                                InputUtil.readString(scanner,
                                        "New Remarks: "));
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        return;
                }

                applicationService.updateApplication(application);

                System.out.println(
                        "Application updated successfully!");

                break;

            } catch (NotFoundException e) {

                System.out.println(
                        "Application not found!");
                System.out.println(
                        "Please enter a valid Application ID.");
            } catch (RuntimeException e) {

                System.out.println(
                        "Update failed!");
                System.out.println(
                        "Please check the entered values.");
                break;
            }
        }
    }


    // DELETE

    private void deleteApplication(Scanner scanner) {

        while (true) {

            int id =
                    InputUtil.readInt(scanner,
                            "Enter Application ID: ");

            try {

                applicationService
                        .getApplicationById(id);

                String answer =
                        InputUtil.readString(scanner,
                                "Delete? yes/no: ");

                if (answer.equalsIgnoreCase("yes")) {

                    applicationService
                            .deleteApplication(id);

                    System.out.println(
                            "Application deleted successfully!");
                } else {

                    System.out.println(
                            "Delete cancelled.");
                }

                break;

            } catch (NotFoundException e) {

                System.out.println(
                        "Application not found!");
                System.out.println(
                        "Please enter a valid Application ID.");
            }
        }
    }


    public static void main(String[] args) {

        LoanApplicationController controller =
                new LoanApplicationController();

        controller.applicationMenu();
    }
}