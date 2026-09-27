package com.loanmanagement.service.impl;

import com.loanmanagement.dao.CustomerDao;
import com.loanmanagement.dao.impl.CustomerDaoImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.Customer;
import com.loanmanagement.service.CustomerService;
import com.loanmanagement.util.ValidationUtil;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao =
            new CustomerDaoImpl();


    // ================= 1. ADD CUSTOMER =================

    @Override
    public void addCustomer(Customer customer) {

        ValidationUtil.validatePositive(
                customer.getUserId(), "User ID");

        ValidationUtil.validateNotEmpty(
                customer.getFullName(), "Full Name");

        ValidationUtil.validateNotEmpty(
                customer.getEmail(), "Email");

        ValidationUtil.validateNotEmpty(
                customer.getPhone(), "Phone");

        ValidationUtil.validatePositive(
                customer.getMonthlyIncome(), "Monthly Income");

        customerDao.addCustomer(customer);
    }


    // ================= 2. GET CUSTOMER =================

    @Override
    public Customer getCustomerById(int customerId) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        Customer customer =
                customerDao.getCustomerById(customerId);

        if (customer == null) {

            throw new NotFoundException(
                    "Customer not found with ID: "
                            + customerId);
        }

        return customer;
    }


    // ================= 3. FULL UPDATE CUSTOMER =================

    @Override
    public void updateCustomer(Customer customer) {

        ValidationUtil.validatePositive(
                customer.getCustomerId(),
                "Customer ID");

        ValidationUtil.validatePositive(
                customer.getUserId(),
                "User ID");

        ValidationUtil.validateNotEmpty(
                customer.getFullName(),
                "Full Name");

        ValidationUtil.validateNotEmpty(
                customer.getEmail(),
                "Email");

        ValidationUtil.validateNotEmpty(
                customer.getPhone(),
                "Phone");

        ValidationUtil.validatePositive(
                customer.getMonthlyIncome(),
                "Monthly Income");

        customerDao.updateCustomer(customer);
    }


    // ================= 4. DELETE CUSTOMER =================

    @Override
    public void deleteCustomer(int customerId) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        customerDao.deleteCustomer(customerId);
    }


    // ================= 5. UPDATE NAME =================

    @Override
    public void updateName(
            int customerId,
            String fullName) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                fullName, "Full Name");

        customerDao.updateName(
                customerId,
                fullName);
    }


    // ================= 6. UPDATE EMAIL =================

    @Override
    public void updateEmail(
            int customerId,
            String email) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                email, "Email");

        customerDao.updateEmail(
                customerId,
                email);
    }


    // ================= 7. UPDATE PHONE =================

    @Override
    public void updatePhone(
            int customerId,
            String phone) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                phone, "Phone");

        customerDao.updatePhone(
                customerId,
                phone);
    }


    // ================= 8. UPDATE ADDRESS =================

    @Override
    public void updateAddress(
            int customerId,
            String address) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                address, "Address");

        customerDao.updateAddress(
                customerId,
                address);
    }


    // ================= 9. UPDATE MONTHLY INCOME =================

    @Override
    public void updateMonthlyIncome(
            int customerId,
            double monthlyIncome) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validatePositive(
                monthlyIncome,
                "Monthly Income");

        customerDao.updateMonthlyIncome(
                customerId,
                monthlyIncome);
    }


    // ================= 10. UPDATE PAN =================

    @Override
    public void updatePanNumber(
            int customerId,
            String panNumber) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                panNumber,
                "PAN Number");

        customerDao.updatePanNumber(
                customerId,
                panNumber);
    }


    // ================= 11. UPDATE AADHAAR =================

    @Override
    public void updateAadhaarLast4(
            int customerId,
            String aadhaarLast4) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                aadhaarLast4,
                "Aadhaar Last 4 Digits");

        customerDao.updateAadhaarLast4(
                customerId,
                aadhaarLast4);
    }


    // ================= 12. UPDATE EMPLOYMENT TYPE =================

    @Override
    public void updateEmploymentType(
            int customerId,
            String employmentType) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                employmentType,
                "Employment Type");

        customerDao.updateEmploymentType(
                customerId,
                employmentType);
    }


    // ================= 13. UPDATE ACCOUNT NUMBER =================

    @Override
    public void updateAccountNumber(
            int customerId,
            String accountNumber) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                accountNumber,
                "Account Number");

        customerDao.updateAccountNumber(
                customerId,
                accountNumber);
    }


    // ================= 14. UPDATE IFSC =================

    @Override
    public void updateIfscCode(
            int customerId,
            String ifscCode) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                ifscCode,
                "IFSC Code");

        customerDao.updateIfscCode(
                customerId,
                ifscCode);
    }


    // ================= 15. UPDATE BANK NAME =================

    @Override
    public void updateBankName(
            int customerId,
            String bankName) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                bankName,
                "Bank Name");

        customerDao.updateBankName(
                customerId,
                bankName);
    }


    // ================= 16. UPDATE CREDIT SCORE =================

    @Override
    public void updateCreditScore(
            int customerId,
            int creditScore) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validatePositive(
                creditScore,
                "Credit Score");

        customerDao.updateCreditScore(
                customerId,
                creditScore);
    }


    // ================= 17. UPDATE EXISTING EMI =================

    @Override
    public void updateExistingEmi(
            int customerId,
            double existingEmi) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validatePositive(
                existingEmi,
                "Existing EMI");

        customerDao.updateExistingEmi(
                customerId,
                existingEmi);
    }


    // ================= 18. UPDATE STATUS =================

    @Override
    public void updateStatus(
            int customerId,
            String status) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        ValidationUtil.validateNotEmpty(
                status,
                "Status");

        customerDao.updateStatus(
                customerId,
                status);
    }
}