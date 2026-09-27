package com.loanmanagement.service;

import com.loanmanagement.model.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerId);

    void updateName(int customerId, String fullName);

    void updateEmail(int customerId, String email);

    void updatePhone(int customerId, String phone);

    void updateAddress(int customerId, String address);

    void updateMonthlyIncome(int customerId, double monthlyIncome);

    void updatePanNumber(int customerId, String panNumber);

    void updateAadhaarLast4(int customerId, String aadhaarLast4);

    void updateEmploymentType(int customerId, String employmentType);

    void updateAccountNumber(int customerId, String accountNumber);

    void updateIfscCode(int customerId, String ifscCode);

    void updateBankName(int customerId, String bankName);

    void updateCreditScore(int customerId, int creditScore);

    void updateExistingEmi(int customerId, double existingEmi);

    void updateStatus(int customerId, String status);
}