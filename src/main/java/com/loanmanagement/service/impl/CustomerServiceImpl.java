package com.loanmanagement.service.impl;

import com.loanmanagement.dao.CustomerDao;
import com.loanmanagement.dao.impl.CustomerDaoImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.Customer;
import com.loanmanagement.service.CustomerService;
import com.loanmanagement.util.ValidationUtil;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

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

    @Override
    public Customer getCustomerById(int customerId) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        Customer customer = customerDao.getCustomerById(customerId);

        if (customer == null) {
            throw new NotFoundException(
                    "Customer not found with ID: " + customerId);
        }

        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {

        ValidationUtil.validatePositive(
                customer.getCustomerId(), "Customer ID");

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

        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {

        ValidationUtil.validatePositive(
                customerId, "Customer ID");

        customerDao.deleteCustomer(customerId);
    }
}