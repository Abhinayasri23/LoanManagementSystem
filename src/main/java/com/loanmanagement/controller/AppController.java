package com.loanmanagement.controller;

import com.loanmanagement.dao.CustomerDao;
import com.loanmanagement.dao.impl.CustomerDaoImpl;
import com.loanmanagement.model.Customer;
import com.loanmanagement.util.DBConnection;

import java.sql.Connection;

public class AppController {

    public static void main(String[] args) {

        // Test database connection
        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("Connection test successful!");
        } else {
            System.out.println("Connection test failed!");
            return;
        }

        // Create Customer DAO object
        CustomerDao customerDao = new CustomerDaoImpl();

        // Create Customer object
        Customer customer = new Customer();

        customer.setUserId(1);
        customer.setFullName("Abhi Vinitha");
        customer.setEmail("abhivinitha@gmail.com");
        customer.setPhone("9876543210");
        customer.setDob("2004-05-15");
        customer.setAddress("Hyderabad");
        customer.setMonthlyIncome(50000);
        customer.setPanNumber("ABCDE1234F");
        customer.setAadhaarLast4("1234");
        customer.setEmploymentType("SALARIED");
        customer.setAccountNumber("1234567890");
        customer.setIfscCode("SBIN0001234");
        customer.setBankName("SBI");
        customer.setKycStatus("PENDING");
        customer.setKycRemarks("Documents submitted");
        customer.setKycVerifiedBy(0);
        customer.setKycVerifiedAt(null);
        customer.setCreditScore(750);
        customer.setExistingEmi(5000);
        customer.setStatus("ACTIVE");

        // Add customer
        customerDao.addCustomer(customer);
    }
}