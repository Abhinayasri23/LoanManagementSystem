package com.loanmanagement.service;

import com.loanmanagement.model.Customer;
import com.loanmanagement.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    private CustomerService customerService = new CustomerServiceImpl();

    @Test
    void getCustomerByIdTest() {

        Customer customer = customerService.getCustomerById(7);

        assertNotNull(customer);
        assertEquals(7, customer.getCustomerId());
    }

    @Test
    void updateCustomerTest() {

        Customer customer = customerService.getCustomerById(7);

        customer.setStatus("ACTIVE");

        customerService.updateCustomer(customer);

        Customer updatedCustomer = customerService.getCustomerById(7);

        assertNotNull(updatedCustomer);
        assertEquals("ACTIVE", updatedCustomer.getStatus());
    }

    @Test
    void getCustomerByIdNotFoundTest() {

        Customer customer = customerService.getCustomerById(999);

        assertNull(customer);
    }
}