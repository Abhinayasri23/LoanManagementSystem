package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.LoanTypeDao;
import com.loanmanagement.model.LoanType;
import com.loanmanagement.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanTypeDaoImpl implements LoanTypeDao {

    @Override
    public void addLoanType(LoanType loanType) {

        String sql = "INSERT INTO loan_types " +
                "(name, description, interest_rate, min_amount, max_amount, max_tenure_months, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, loanType.getName());
            statement.setString(2, loanType.getDescription());
            statement.setDouble(3, loanType.getInterestRate());
            statement.setDouble(4, loanType.getMinAmount());
            statement.setDouble(5, loanType.getMaxAmount());
            statement.setInt(6, loanType.getMaxTenureMonths());
            statement.setString(7, loanType.getStatus());

            statement.executeUpdate();

            System.out.println("Loan type added successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while adding loan type.");
            e.printStackTrace();
        }
    }

    @Override
    public LoanType getLoanTypeById(int loanTypeId) {

        String sql = "SELECT * FROM loan_types WHERE loan_type_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, loanTypeId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                LoanType loanType = new LoanType();

                loanType.setLoanTypeId(resultSet.getInt("loan_type_id"));
                loanType.setName(resultSet.getString("name"));
                loanType.setDescription(resultSet.getString("description"));
                loanType.setInterestRate(resultSet.getDouble("interest_rate"));
                loanType.setMinAmount(resultSet.getDouble("min_amount"));
                loanType.setMaxAmount(resultSet.getDouble("max_amount"));
                loanType.setMaxTenureMonths(resultSet.getInt("max_tenure_months"));
                loanType.setStatus(resultSet.getString("status"));

                resultSet.close();
                statement.close();
                connection.close();

                return loanType;
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while getting loan type.");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateLoanType(LoanType loanType) {

        String sql = "UPDATE loan_types SET " +
                "name = ?, description = ?, interest_rate = ?, " +
                "min_amount = ?, max_amount = ?, max_tenure_months = ?, " +
                "status = ? " +
                "WHERE loan_type_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, loanType.getName());
            statement.setString(2, loanType.getDescription());
            statement.setDouble(3, loanType.getInterestRate());
            statement.setDouble(4, loanType.getMinAmount());
            statement.setDouble(5, loanType.getMaxAmount());
            statement.setInt(6, loanType.getMaxTenureMonths());
            statement.setString(7, loanType.getStatus());
            statement.setInt(8, loanType.getLoanTypeId());

            statement.executeUpdate();

            System.out.println("Loan type updated successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while updating loan type.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLoanType(int loanTypeId) {

        String sql = "DELETE FROM loan_types WHERE loan_type_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, loanTypeId);

            statement.executeUpdate();

            System.out.println("Loan type deleted successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while deleting loan type.");
            e.printStackTrace();
        }
    }
}