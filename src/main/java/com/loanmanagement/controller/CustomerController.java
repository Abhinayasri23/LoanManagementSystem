package com.loanmanagement.controller;

import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.Customer;
import com.loanmanagement.service.CustomerService;
import com.loanmanagement.service.impl.CustomerServiceImpl;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerController {

    private static final Logger logger =
            LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService =
            new CustomerServiceImpl();


    // ================= CUSTOMER MENU =================

    public void customerMenu() {

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("========== CUSTOMER MANAGEMENT ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back");
            System.out.println("=========================================");

            choice = InputUtil.readInt(
                    scanner,
                    "Enter your choice: ");

            switch (choice) {

                case 1:
                    addCustomer(scanner);
                    break;

                case 2:
                    getCustomer(scanner);
                    break;

                case 3:
                    updateCustomer(scanner);
                    break;

                case 4:
                    deleteCustomer(scanner);
                    break;

                case 5:
                    System.out.println(
                            "Returning to main menu...");
                    break;

                default:
                    System.out.println(
                            "Invalid choice!");
                    System.out.println(
                            "Please enter a valid option.");
            }

        } while (choice != 5);
    }


    // ================= ADD CUSTOMER =================

    private void addCustomer(Scanner scanner) {

        Customer customer = new Customer();

        System.out.println();
        System.out.println("========== ADD CUSTOMER ==========");

        int userId =
                InputUtil.readInt(
                        scanner,
                        "Enter User ID: ");

        customer.setUserId(userId);

        String fullName =
                InputUtil.readString(
                        scanner,
                        "Enter Full Name: ");

        customer.setFullName(fullName);

        String dob =
                InputUtil.readString(
                        scanner,
                        "Enter Date of Birth: ");

        customer.setDob(dob);

        String address =
                InputUtil.readString(
                        scanner,
                        "Enter Address: ");

        customer.setAddress(address);

        String email =
                InputUtil.readString(
                        scanner,
                        "Enter Email: ");

        customer.setEmail(email);

        String phone =
                InputUtil.readString(
                        scanner,
                        "Enter Phone: ");

        customer.setPhone(phone);

        double monthlyIncome =
                InputUtil.readDouble(
                        scanner,
                        "Enter Monthly Income: ");

        customer.setMonthlyIncome(monthlyIncome);

        String panNumber =
                InputUtil.readString(
                        scanner,
                        "Enter PAN Number: ");

        customer.setPanNumber(panNumber);

        String aadhaarLast4 =
                InputUtil.readString(
                        scanner,
                        "Enter Aadhaar Last 4 Digits: ");

        customer.setAadhaarLast4(aadhaarLast4);

        String employmentType =
                InputUtil.readString(
                        scanner,
                        "Enter Employment Type: ");

        customer.setEmploymentType(employmentType);

        String accountNumber =
                InputUtil.readString(
                        scanner,
                        "Enter Account Number: ");

        customer.setAccountNumber(accountNumber);

        String ifscCode =
                InputUtil.readString(
                        scanner,
                        "Enter IFSC Code: ");

        customer.setIfscCode(ifscCode);

        String bankName =
                InputUtil.readString(
                        scanner,
                        "Enter Bank Name: ");

        customer.setBankName(bankName);

        int creditScore =
                InputUtil.readInt(
                        scanner,
                        "Enter Credit Score: ");

        customer.setCreditScore(creditScore);

        double existingEmi =
                InputUtil.readDouble(
                        scanner,
                        "Enter Existing EMI: ");

        customer.setExistingEmi(existingEmi);

        String status =
                InputUtil.readString(
                        scanner,
                        "Enter Customer Status: ");

        customer.setStatus(status);

        // KYC fields are not collected.
        // KYC is not required as a separate module.

        try {

            customerService.addCustomer(customer);

            System.out.println();
            System.out.println(
                    "Customer added successfully!");

            logger.info(
                    "Customer added successfully!");

        } catch (RuntimeException e) {

            System.out.println();
            System.out.println(
                    "Customer could not be added.");

            System.out.println(
                    "Please check the entered details and try again.");

            logger.error(
                    "Error while adding customer",
                    e);
        }
    }


    // ================= VIEW CUSTOMER =================

    private void getCustomer(Scanner scanner) {

        System.out.println();
        System.out.println("========== VIEW CUSTOMER ==========");

        while (true) {

            int customerId =
                    InputUtil.readInt(
                            scanner,
                            "Enter Customer ID: ");

            try {

                Customer customer =
                        customerService.getCustomerById(
                                customerId);

                System.out.println();
                System.out.println(
                        "========== CUSTOMER DETAILS ==========");

                System.out.println(
                        "Customer ID       : "
                                + customer.getCustomerId());

                System.out.println(
                        "User ID           : "
                                + customer.getUserId());

                System.out.println(
                        "Full Name         : "
                                + customer.getFullName());

                System.out.println(
                        "Date of Birth     : "
                                + customer.getDob());

                System.out.println(
                        "Address           : "
                                + customer.getAddress());

                System.out.println(
                        "Email             : "
                                + customer.getEmail());

                System.out.println(
                        "Phone             : "
                                + customer.getPhone());

                System.out.println(
                        "Monthly Income    : "
                                + customer.getMonthlyIncome());

                System.out.println(
                        "PAN Number        : "
                                + customer.getPanNumber());

                System.out.println(
                        "Aadhaar Last 4    : "
                                + customer.getAadhaarLast4());

                System.out.println(
                        "Employment Type   : "
                                + customer.getEmploymentType());

                System.out.println(
                        "Account Number    : "
                                + customer.getAccountNumber());

                System.out.println(
                        "IFSC Code         : "
                                + customer.getIfscCode());

                System.out.println(
                        "Bank Name         : "
                                + customer.getBankName());

                System.out.println(
                        "Credit Score      : "
                                + customer.getCreditScore());

                System.out.println(
                        "Existing EMI      : "
                                + customer.getExistingEmi());

                System.out.println(
                        "Status            : "
                                + customer.getStatus());

                System.out.println(
                        "======================================");

                logger.info(
                        "Customer fetched successfully!");

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Customer not found!");

                System.out.println(
                        "Please enter Customer ID again.");

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Unable to view customer.");

                System.out.println(
                        "Please try again.");

                logger.error(
                        "Error while viewing customer",
                        e);
            }
        }
    }


    // ================= UPDATE CUSTOMER =================

    private void updateCustomer(Scanner scanner) {

        System.out.println();
        System.out.println("========== UPDATE CUSTOMER ==========");

        while (true) {

            int customerId =
                    InputUtil.readInt(
                            scanner,
                            "Enter Customer ID: ");

            try {

                Customer customer =
                        customerService.getCustomerById(
                                customerId);

                System.out.println();
                System.out.println(
                        "Customer Found: "
                                + customer.getFullName());

                System.out.println();
                System.out.println(
                        "What do you want to update?");

                System.out.println("1. Full Name");
                System.out.println("2. Email");
                System.out.println("3. Phone");
                System.out.println("4. Address");
                System.out.println("5. Monthly Income");
                System.out.println("6. PAN Number");
                System.out.println("7. Aadhaar Last 4 Digits");
                System.out.println("8. Employment Type");
                System.out.println("9. Account Number");
                System.out.println("10. IFSC Code");
                System.out.println("11. Bank Name");
                System.out.println("12. Credit Score");
                System.out.println("13. Existing EMI");
                System.out.println("14. Status");
                System.out.println("15. Cancel");

                int choice =
                        InputUtil.readInt(
                                scanner,
                                "Enter your choice: ");

                switch (choice) {

                    case 1:

                        String fullName =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Full Name: ");

                        customerService.updateName(
                                customerId,
                                fullName);

                        System.out.println(
                                "Full Name updated successfully!");

                        break;


                    case 2:

                        String email =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Email: ");

                        customerService.updateEmail(
                                customerId,
                                email);

                        System.out.println(
                                "Email updated successfully!");

                        break;


                    case 3:

                        String phone =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Phone: ");

                        customerService.updatePhone(
                                customerId,
                                phone);

                        System.out.println(
                                "Phone updated successfully!");

                        break;


                    case 4:

                        String address =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Address: ");

                        customerService.updateAddress(
                                customerId,
                                address);

                        System.out.println(
                                "Address updated successfully!");

                        break;


                    case 5:

                        double monthlyIncome =
                                InputUtil.readDouble(
                                        scanner,
                                        "Enter New Monthly Income: ");

                        customerService.updateMonthlyIncome(
                                customerId,
                                monthlyIncome);

                        System.out.println(
                                "Monthly Income updated successfully!");

                        break;


                    case 6:

                        String panNumber =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New PAN Number: ");

                        customerService.updatePanNumber(
                                customerId,
                                panNumber);

                        System.out.println(
                                "PAN Number updated successfully!");

                        break;


                    case 7:

                        String aadhaarLast4 =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Aadhaar Last 4 Digits: ");

                        customerService.updateAadhaarLast4(
                                customerId,
                                aadhaarLast4);

                        System.out.println(
                                "Aadhaar updated successfully!");

                        break;


                    case 8:

                        String employmentType =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Employment Type: ");

                        customerService.updateEmploymentType(
                                customerId,
                                employmentType);

                        System.out.println(
                                "Employment Type updated successfully!");

                        break;


                    case 9:

                        String accountNumber =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Account Number: ");

                        customerService.updateAccountNumber(
                                customerId,
                                accountNumber);

                        System.out.println(
                                "Account Number updated successfully!");

                        break;


                    case 10:

                        String ifscCode =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New IFSC Code: ");

                        customerService.updateIfscCode(
                                customerId,
                                ifscCode);

                        System.out.println(
                                "IFSC Code updated successfully!");

                        break;


                    case 11:

                        String bankName =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Bank Name: ");

                        customerService.updateBankName(
                                customerId,
                                bankName);

                        System.out.println(
                                "Bank Name updated successfully!");

                        break;


                    case 12:

                        int creditScore =
                                InputUtil.readInt(
                                        scanner,
                                        "Enter New Credit Score: ");

                        customerService.updateCreditScore(
                                customerId,
                                creditScore);

                        System.out.println(
                                "Credit Score updated successfully!");

                        break;


                    case 13:

                        double existingEmi =
                                InputUtil.readDouble(
                                        scanner,
                                        "Enter New Existing EMI: ");

                        customerService.updateExistingEmi(
                                customerId,
                                existingEmi);

                        System.out.println(
                                "Existing EMI updated successfully!");

                        break;


                    case 14:

                        String status =
                                InputUtil.readString(
                                        scanner,
                                        "Enter New Status: ");

                        customerService.updateStatus(
                                customerId,
                                status);

                        System.out.println(
                                "Status updated successfully!");

                        break;


                    case 15:

                        System.out.println(
                                "Update operation cancelled.");

                        return;


                    default:

                        System.out.println(
                                "Invalid choice!");

                        System.out.println(
                                "Please enter a valid option.");

                        continue;
                }

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Customer not found!");

                System.out.println(
                        "Please enter Customer ID again.");

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Update failed.");

                System.out.println(
                        "Please try again.");

                logger.error(
                        "Error while updating customer",
                        e);
            }
        }
    }


    // ================= DELETE CUSTOMER =================

    private void deleteCustomer(Scanner scanner) {

        System.out.println();
        System.out.println(
                "========== DELETE CUSTOMER ==========");

        while (true) {

            int customerId =
                    InputUtil.readInt(
                            scanner,
                            "Enter Customer ID: ");

            try {

                customerService.getCustomerById(
                        customerId);

                String confirmation =
                        InputUtil.readString(
                                scanner,
                                "Are you sure you want to delete? (yes/no): ");

                if (confirmation.equalsIgnoreCase("yes")) {

                    customerService.deleteCustomer(
                            customerId);

                    System.out.println(
                            "Customer deleted successfully!");

                    logger.info(
                            "Customer deleted successfully!");

                } else {

                    System.out.println(
                            "Delete operation cancelled.");
                }

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "Customer not found!");

                System.out.println(
                        "Please enter Customer ID again.");

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Delete failed.");

                System.out.println(
                        "Please try again.");

                logger.error(
                        "Error while deleting customer",
                        e);
            }
        }
    }

}