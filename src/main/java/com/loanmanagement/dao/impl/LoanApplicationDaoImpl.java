package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.LoanApplicationDao;
import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanApplicationDaoImpl implements LoanApplicationDao {

    @Override
    public void addLoanApplication(LoanApplication application) {

        String sql = "INSERT INTO loan_applications " +
                "(customer_id, loan_type_id, requested_amount, tenure_months, " +
                "purpose, status, remarks, reviewed_by, applied_at, reviewed_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, application.getCustomerId());
            statement.setInt(2, application.getLoanTypeId());
            statement.setDouble(3, application.getRequestedAmount());
            statement.setInt(4, application.getTenureMonths());
            statement.setString(5, application.getPurpose());
            statement.setString(6, application.getStatus());
            statement.setString(7, application.getRemarks());

            if (application.getReviewedBy() == 0) {
                statement.setNull(8, java.sql.Types.INTEGER);
            } else {
                statement.setInt(8, application.getReviewedBy());
            }

            statement.setString(9, application.getAppliedAt());
            statement.setString(10, application.getReviewedAt());

            statement.executeUpdate();

            System.out.println("Loan application added successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while adding loan application.");
            e.printStackTrace();
        }
    }

    @Override
    public LoanApplication getLoanApplicationById(int applicationId) {

        String sql = "SELECT * FROM loan_applications WHERE application_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, applicationId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                LoanApplication application = new LoanApplication();

                application.setApplicationId(
                        resultSet.getInt("application_id"));

                application.setCustomerId(
                        resultSet.getInt("customer_id"));

                application.setLoanTypeId(
                        resultSet.getInt("loan_type_id"));

                application.setRequestedAmount(
                        resultSet.getDouble("requested_amount"));

                application.setTenureMonths(
                        resultSet.getInt("tenure_months"));

                application.setPurpose(
                        resultSet.getString("purpose"));

                application.setStatus(
                        resultSet.getString("status"));

                application.setRemarks(
                        resultSet.getString("remarks"));

                application.setReviewedBy(
                        resultSet.getInt("reviewed_by"));

                application.setAppliedAt(
                        resultSet.getString("applied_at"));

                application.setReviewedAt(
                        resultSet.getString("reviewed_at"));

                resultSet.close();
                statement.close();
                connection.close();

                return application;
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while getting loan application.");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateLoanApplication(LoanApplication application) {

        String sql = "UPDATE loan_applications SET " +
                "customer_id = ?, loan_type_id = ?, requested_amount = ?, " +
                "tenure_months = ?, purpose = ?, status = ?, remarks = ? " +
                "WHERE application_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, application.getCustomerId());
            statement.setInt(2, application.getLoanTypeId());
            statement.setDouble(3, application.getRequestedAmount());
            statement.setInt(4, application.getTenureMonths());
            statement.setString(5, application.getPurpose());
            statement.setString(6, application.getStatus());
            statement.setString(7, application.getRemarks());

            statement.setInt(8, application.getApplicationId());

            statement.executeUpdate();

            System.out.println("Loan application updated successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while updating loan application.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLoanApplication(int applicationId) {

        String sql = "DELETE FROM loan_applications WHERE application_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, applicationId);

            statement.executeUpdate();

            System.out.println("Loan application deleted successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while deleting loan application.");
            e.printStackTrace();
        }
    }
}