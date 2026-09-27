package com.loanmanagement.controller;

import com.loanmanagement.model.LoanType;
import com.loanmanagement.service.LoanTypeService;
import com.loanmanagement.service.impl.LoanTypeServiceImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

public class LoanTypeController {

    private LoanTypeService loanTypeService =
            new LoanTypeServiceImpl();


    // ================= LOAN TYPE MENU =================

    public void loanTypeMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("======= LOAN TYPE MANAGEMENT =======");
            System.out.println("1. Add Loan Type");
            System.out.println("2. View Loan Type");
            System.out.println("3. Update Loan Type");
            System.out.println("4. Delete Loan Type");
            System.out.println("5. Back");

            int choice =
                    InputUtil.readInt(
                            scanner,
                            "Enter choice: ");

            switch (choice) {

                case 1:
                    addLoanType(scanner);
                    break;

                case 2:
                    getLoanType(scanner);
                    break;

                case 3:
                    updateLoanType(scanner);
                    break;

                case 4:
                    deleteLoanType(scanner);
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


    // ================= ADD LOAN TYPE =================

    private void addLoanType(Scanner scanner) {

        while (true) {

            try {

                LoanType loanType =
                        new LoanType();

                loanType.setName(
                        InputUtil.readString(
                                scanner,
                                "Enter Loan Type Name: "));

                loanType.setDescription(
                        InputUtil.readString(
                                scanner,
                                "Enter Description: "));

                loanType.setInterestRate(
                        InputUtil.readDouble(
                                scanner,
                                "Enter Interest Rate: "));

                loanType.setMinAmount(
                        InputUtil.readDouble(
                                scanner,
                                "Enter Minimum Amount: "));

                loanType.setMaxAmount(
                        InputUtil.readDouble(
                                scanner,
                                "Enter Maximum Amount: "));

                loanType.setMaxTenureMonths(
                        InputUtil.readInt(
                                scanner,
                                "Enter Maximum Tenure: "));

                loanTypeService.addLoanType(
                        loanType);

                System.out.println();
                System.out.println(
                        "Loan type added successfully!");

                break;

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Invalid loan type details!");

                System.out.println(
                        "Please enter the details again.");
            }
        }
    }


    // ================= VIEW LOAN TYPE =================

    private void getLoanType(Scanner scanner) {

        while (true) {

            int id =
                    InputUtil.readInt(
                            scanner,
                            "Enter Loan Type ID: ");

            try {

                LoanType loanType =
                        loanTypeService
                                .getLoanTypeById(id);

                System.out.println();
                System.out.println(
                        "======= LOAN TYPE DETAILS =======");

                System.out.println(
                        "Loan Type ID : "
                                + loanType.getLoanTypeId());

                System.out.println(
                        "Name         : "
                                + loanType.getName());

                System.out.println(
                        "Description  : "
                                + loanType.getDescription());

                System.out.println(
                        "Interest Rate: "
                                + loanType.getInterestRate());

                System.out.println(
                        "Min Amount   : "
                                + loanType.getMinAmount());

                System.out.println(
                        "Max Amount   : "
                                + loanType.getMaxAmount());

                System.out.println(
                        "Max Tenure   : "
                                + loanType.getMaxTenureMonths());

                System.out.println(
                        "=================================");

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Loan type not found!");

                System.out.println(
                        "Please enter Loan Type ID again.");
            }
        }
    }


    // ================= UPDATE LOAN TYPE =================

    private void updateLoanType(Scanner scanner) {

        while (true) {

            int id =
                    InputUtil.readInt(
                            scanner,
                            "Enter Loan Type ID: ");

            try {

                LoanType loanType =
                        loanTypeService
                                .getLoanTypeById(id);

                System.out.println();
                System.out.println("1. Name");
                System.out.println("2. Description");
                System.out.println("3. Interest Rate");
                System.out.println("4. Minimum Amount");
                System.out.println("5. Maximum Amount");
                System.out.println("6. Maximum Tenure");
                System.out.println("7. Cancel");

                int choice =
                        InputUtil.readInt(
                                scanner,
                                "Enter field choice: ");

                switch (choice) {

                    case 1:

                        loanType.setName(
                                InputUtil.readString(
                                        scanner,
                                        "New Name: "));

                        break;

                    case 2:

                        loanType.setDescription(
                                InputUtil.readString(
                                        scanner,
                                        "New Description: "));

                        break;

                    case 3:

                        loanType.setInterestRate(
                                InputUtil.readDouble(
                                        scanner,
                                        "New Interest Rate: "));

                        break;

                    case 4:

                        loanType.setMinAmount(
                                InputUtil.readDouble(
                                        scanner,
                                        "New Minimum Amount: "));

                        break;

                    case 5:

                        loanType.setMaxAmount(
                                InputUtil.readDouble(
                                        scanner,
                                        "New Maximum Amount: "));

                        break;

                    case 6:

                        loanType.setMaxTenureMonths(
                                InputUtil.readInt(
                                        scanner,
                                        "New Maximum Tenure: "));

                        break;

                    case 7:

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

                loanTypeService.updateLoanType(
                        loanType);

                System.out.println();
                System.out.println(
                        "Loan type updated successfully!");

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Loan type not found!");

                System.out.println(
                        "Please enter Loan Type ID again.");

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


    // ================= DELETE LOAN TYPE =================

    private void deleteLoanType(Scanner scanner) {

        while (true) {

            int id =
                    InputUtil.readInt(
                            scanner,
                            "Enter Loan Type ID: ");

            try {

                loanTypeService
                        .getLoanTypeById(id);

                String answer =
                        InputUtil.readString(
                                scanner,
                                "Delete? yes/no: ");

                if (answer.equalsIgnoreCase("yes")) {

                    loanTypeService
                            .deleteLoanType(id);

                    System.out.println();
                    System.out.println(
                            "Loan type deleted successfully!");

                } else {

                    System.out.println();
                    System.out.println(
                            "Delete cancelled.");
                }

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Loan type not found!");

                System.out.println(
                        "Please enter Loan Type ID again.");
            }
        }
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        LoanTypeController controller =
                new LoanTypeController();

        controller.loanTypeMenu();
    }
}