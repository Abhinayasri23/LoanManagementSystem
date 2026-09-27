package com.loanmanagement.controller;

import com.loanmanagement.model.Loan;
import com.loanmanagement.service.LoanService;
import com.loanmanagement.service.impl.LoanServiceImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

public class LoanController {

    private LoanService loanService =
            new LoanServiceImpl();


    // ================= LOAN MENU =================

    public void loanMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("========== LOAN MANAGEMENT ==========");
            System.out.println("1. Create Loan");
            System.out.println("2. View Loan");
            System.out.println("3. Update Loan");
            System.out.println("4. Delete Loan");
            System.out.println("5. Back");

            int choice =
                    InputUtil.readInt(
                            scanner,
                            "Enter choice: ");

            switch (choice) {

                case 1:
                    addLoan(scanner);
                    break;

                case 2:
                    getLoan(scanner);
                    break;

                case 3:
                    updateLoan(scanner);
                    break;

                case 4:
                    deleteLoan(scanner);
                    break;

                case 5:
                    return;

                default:
                    System.out.println();
                    System.out.println(
                            "Invalid choice!");

                    System.out.println(
                            "Please enter a valid option.");
            }
        }
    }


    // ================= ADD LOAN =================

    private void addLoan(Scanner scanner) {

        while (true) {

            try {

                Loan loan = new Loan();

                loan.setApplicationId(
                        InputUtil.readInt(
                                scanner,
                                "Enter Application ID: "));

                loan.setCustomerId(
                        InputUtil.readInt(
                                scanner,
                                "Enter Customer ID: "));

                loan.setLoanTypeId(
                        InputUtil.readInt(
                                scanner,
                                "Enter Loan Type ID: "));

                loan.setPrincipalAmount(
                        InputUtil.readDouble(
                                scanner,
                                "Enter Principal Amount: "));

                loan.setInterestRate(
                        InputUtil.readDouble(
                                scanner,
                                "Enter Interest Rate: "));

                loan.setTenureMonths(
                        InputUtil.readInt(
                                scanner,
                                "Enter Tenure (months): "));

                loan.setCreatedBy(
                        InputUtil.readInt(
                                scanner,
                                "Enter Created By (User ID): "));

                loan.setStatus(
                        InputUtil.readString(
                                scanner,
                                "Enter Loan Status: "));

                loanService.addLoan(loan);

                System.out.println();
                System.out.println(
                        "Loan created successfully!");

                break;

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Invalid loan details!");

                System.out.println(
                        "Please enter the details again.");
            }
        }
    }


    // ================= VIEW LOAN =================

    private void getLoan(Scanner scanner) {

        while (true) {

            int loanId =
                    InputUtil.readInt(
                            scanner,
                            "Enter Loan ID: ");

            try {

                Loan loan =
                        loanService.getLoanById(
                                loanId);

                System.out.println();
                System.out.println(
                        "========== LOAN DETAILS ==========");

                System.out.println(
                        "Loan ID          : "
                                + loan.getLoanId());

                System.out.println(
                        "Application ID   : "
                                + loan.getApplicationId());

                System.out.println(
                        "Customer ID      : "
                                + loan.getCustomerId());

                System.out.println(
                        "Loan Type ID     : "
                                + loan.getLoanTypeId());

                System.out.println(
                        "Principal Amount : "
                                + loan.getPrincipalAmount());

                System.out.println(
                        "Interest Rate    : "
                                + loan.getInterestRate());

                System.out.println(
                        "Tenure (Months)  : "
                                + loan.getTenureMonths());

                System.out.println(
                        "Created By       : "
                                + loan.getCreatedBy());

                System.out.println(
                        "Status           : "
                                + loan.getStatus());

                System.out.println(
                        "==================================");

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Loan not found!");

                System.out.println(
                        "Please enter Loan ID again.");
            }
        }
    }


    // ================= UPDATE LOAN =================

    private void updateLoan(Scanner scanner) {

        while (true) {

            int loanId =
                    InputUtil.readInt(
                            scanner,
                            "Enter Loan ID: ");

            try {

                Loan loan =
                        loanService.getLoanById(
                                loanId);

                System.out.println();
                System.out.println(
                        "1. Principal Amount");

                System.out.println(
                        "2. Interest Rate");

                System.out.println(
                        "3. Tenure");

                System.out.println(
                        "4. Status");

                System.out.println(
                        "5. Cancel");

                int choice =
                        InputUtil.readInt(
                                scanner,
                                "Enter field choice: ");

                switch (choice) {

                    case 1:

                        loan.setPrincipalAmount(
                                InputUtil.readDouble(
                                        scanner,
                                        "New Principal Amount: "));

                        break;

                    case 2:

                        loan.setInterestRate(
                                InputUtil.readDouble(
                                        scanner,
                                        "New Interest Rate: "));

                        break;

                    case 3:

                        loan.setTenureMonths(
                                InputUtil.readInt(
                                        scanner,
                                        "New Tenure: "));

                        break;

                    case 4:

                        loan.setStatus(
                                InputUtil.readString(
                                        scanner,
                                        "New Status: "));

                        break;

                    case 5:

                        System.out.println(
                                "Update cancelled.");

                        return;

                    default:

                        System.out.println();
                        System.out.println(
                                "Invalid choice!");

                        System.out.println(
                                "Please enter a valid option.");

                        continue;
                }

                loanService.updateLoan(loan);

                System.out.println();
                System.out.println(
                        "Loan updated successfully!");

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Loan not found!");

                System.out.println(
                        "Please enter Loan ID again.");

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Update failed!");

                System.out.println(
                        "Please check the entered values.");

                System.out.println(
                        "Please try again.");
            }
        }
    }


    // ================= DELETE LOAN =================

    private void deleteLoan(Scanner scanner) {

        while (true) {

            int loanId =
                    InputUtil.readInt(
                            scanner,
                            "Enter Loan ID: ");

            try {

                loanService.getLoanById(
                        loanId);

                String answer =
                        InputUtil.readString(
                                scanner,
                                "Delete? yes/no: ");

                if (answer.equalsIgnoreCase("yes")) {

                    loanService.deleteLoan(
                            loanId);

                    System.out.println();
                    System.out.println(
                            "Loan deleted successfully!");

                } else {

                    System.out.println();
                    System.out.println(
                            "Delete cancelled.");
                }

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Loan not found!");

                System.out.println(
                        "Please enter Loan ID again.");
            }
        }
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        LoanController controller =
                new LoanController();

        controller.loanMenu();
    }
}