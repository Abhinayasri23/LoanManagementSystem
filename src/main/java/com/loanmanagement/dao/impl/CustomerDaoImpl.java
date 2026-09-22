package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.CustomerDao;
import com.loanmanagement.model.Customer;
import com.loanmanagement.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    // 1. ADD CUSTOMER
    @Override
    public void addCustomer(Customer customer) {

        String sql = "INSERT INTO customers " +
                "(user_id, full_name, email, phone, dob, address, monthly_income, " +
                "pan_number, aadhaar_last4, employment_type, account_number, " +
                "ifsc_code, bank_name, kyc_status, kyc_remarks, kyc_verified_by, " +
                "kyc_verified_at, credit_score, existing_emi, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, customer.getUserId());
            statement.setString(2, customer.getFullName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getDob());
            statement.setString(6, customer.getAddress());
            statement.setDouble(7, customer.getMonthlyIncome());
            statement.setString(8, customer.getPanNumber());
            statement.setString(9, customer.getAadhaarLast4());
            statement.setString(10, customer.getEmploymentType());
            statement.setString(11, customer.getAccountNumber());
            statement.setString(12, customer.getIfscCode());
            statement.setString(13, customer.getBankName());
            statement.setString(14, customer.getKycStatus());
            statement.setString(15, customer.getKycRemarks());

            if (customer.getKycVerifiedBy() == 0) {
                statement.setNull(16, java.sql.Types.INTEGER);
            } else {
                statement.setInt(16, customer.getKycVerifiedBy());
            }

            statement.setString(17, customer.getKycVerifiedAt());
            statement.setInt(18, customer.getCreditScore());
            statement.setDouble(19, customer.getExistingEmi());
            statement.setString(20, customer.getStatus());

            statement.executeUpdate();

            System.out.println("Customer added successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while adding customer.");
            e.printStackTrace();
        }
    }


    // 2. GET CUSTOMER BY ID
    @Override
    public Customer getCustomerById(int customerId) {

        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, customerId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(
                        resultSet.getInt("customer_id"));

                customer.setUserId(
                        resultSet.getInt("user_id"));

                customer.setFullName(
                        resultSet.getString("full_name"));

                customer.setEmail(
                        resultSet.getString("email"));

                customer.setPhone(
                        resultSet.getString("phone"));

                customer.setDob(
                        resultSet.getString("dob"));

                customer.setAddress(
                        resultSet.getString("address"));

                customer.setMonthlyIncome(
                        resultSet.getDouble("monthly_income"));

                customer.setPanNumber(
                        resultSet.getString("pan_number"));

                customer.setAadhaarLast4(
                        resultSet.getString("aadhaar_last4"));

                customer.setEmploymentType(
                        resultSet.getString("employment_type"));

                customer.setAccountNumber(
                        resultSet.getString("account_number"));

                customer.setIfscCode(
                        resultSet.getString("ifsc_code"));

                customer.setBankName(
                        resultSet.getString("bank_name"));

                customer.setKycStatus(
                        resultSet.getString("kyc_status"));

                customer.setKycRemarks(
                        resultSet.getString("kyc_remarks"));

                customer.setKycVerifiedBy(
                        resultSet.getInt("kyc_verified_by"));

                customer.setKycVerifiedAt(
                        resultSet.getString("kyc_verified_at"));

                customer.setCreditScore(
                        resultSet.getInt("credit_score"));

                customer.setExistingEmi(
                        resultSet.getDouble("existing_emi"));

                customer.setStatus(
                        resultSet.getString("status"));

                resultSet.close();
                statement.close();
                connection.close();

                return customer;
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while getting customer.");
            e.printStackTrace();
        }

        return null;
    }


    // 3. UPDATE CUSTOMER
    @Override
    public void updateCustomer(Customer customer) {

        String sql = "UPDATE customers SET " +
                "user_id = ?, full_name = ?, email = ?, phone = ?, dob = ?, " +
                "address = ?, monthly_income = ?, pan_number = ?, aadhaar_last4 = ?, " +
                "employment_type = ?, account_number = ?, ifsc_code = ?, bank_name = ?, " +
                "kyc_status = ?, kyc_remarks = ?, kyc_verified_by = ?, " +
                "kyc_verified_at = ?, credit_score = ?, existing_emi = ?, status = ? " +
                "WHERE customer_id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, customer.getUserId());
            statement.setString(2, customer.getFullName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getDob());
            statement.setString(6, customer.getAddress());
            statement.setDouble(7, customer.getMonthlyIncome());
            statement.setString(8, customer.getPanNumber());
            statement.setString(9, customer.getAadhaarLast4());
            statement.setString(10, customer.getEmploymentType());
            statement.setString(11, customer.getAccountNumber());
            statement.setString(12, customer.getIfscCode());
            statement.setString(13, customer.getBankName());
            statement.setString(14, customer.getKycStatus());
            statement.setString(15, customer.getKycRemarks());

            if (customer.getKycVerifiedBy() == 0) {
                statement.setNull(16, java.sql.Types.INTEGER);
            } else {
                statement.setInt(16, customer.getKycVerifiedBy());
            }

            statement.setString(17, customer.getKycVerifiedAt());
            statement.setInt(18, customer.getCreditScore());
            statement.setDouble(19, customer.getExistingEmi());
            statement.setString(20, customer.getStatus());

            statement.setInt(21, customer.getCustomerId());

            statement.executeUpdate();

            System.out.println("Customer updated successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while updating customer.");
            e.printStackTrace();
        }
    }


    // 4. DELETE CUSTOMER
    @Override
    public void deleteCustomer(int customerId) {

        String sql =
                "DELETE FROM customers WHERE customer_id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, customerId);

            statement.executeUpdate();

            System.out.println("Customer deleted successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while deleting customer.");
            e.printStackTrace();
        }
    }
}