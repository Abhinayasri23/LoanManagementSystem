package com.loanmanagement.controller;

import com.loanmanagement.model.Customer;
import com.loanmanagement.service.CustomerService;
import com.loanmanagement.service.impl.CustomerServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerController {

    private static final Logger logger =
            LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService =
            new CustomerServiceImpl();

    // Get Customer
    public void getCustomer(int customerId) {

        Customer customer =
                customerService.getCustomerById(customerId);

        logger.info("Customer fetched successfully!");
        logger.info("Customer Name: {}", customer.getFullName());
    }

    // Update Customer
    public void updateCustomer(Customer customer) {

        customerService.updateCustomer(customer);

        logger.info("Customer update completed!");
    }

    // Test
    public static void main(String[] args) {

        CustomerController customerController =
                new CustomerController();

        // Get existing customer
        customerController.getCustomer(7);
    }
}