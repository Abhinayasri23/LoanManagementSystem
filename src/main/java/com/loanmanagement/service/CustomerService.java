package com.loanmanagement.service;

import com.loanmanagement.model.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerId);
}
