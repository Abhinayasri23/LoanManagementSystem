package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.LoanApplicationDao;
import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.util.DBConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanApplicationDaoImpl implements LoanApplicationDao {

    private static final Logger logger =
            LoggerFactory.getLogger(LoanApplicationDaoImpl.class);

    // SQL QUERIES
    private static final String ADD_LOAN_APPLICATION_SQL =
            "INSERT INTO loan_applications " +
                    "(customer_id, loan_type_id, requested_amount, tenure_months, " +
                    "purpose, status, remarks, reviewed_by, applied_at, reviewed_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_LOAN_APPLICATION_BY_ID_SQL =
            "SELECT * FROM loan_applications WHERE application_id = ?";

    private static final String UPDATE_LOAN_APPLICATION_SQL =
            "UPDATE loan_applications SET " +
                    "customer_id = ?, loan_type_id = ?, requested_amount = ?, " +
                    "tenure_months = ?, purpose = ?, status = ?, remarks = ? " +
                    "WHERE application_id = ?";

    private static final String DELETE_LOAN_APPLICATION_SQL =
            "DELETE FROM loan_applications WHERE application_id = ?";


    @Override
    public void addLoanApplication(LoanApplication application) {

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(
                            ADD_LOAN_APPLICATION_SQL);

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

            logger.info("Loan application added successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while adding loan application.", e);
        }
    }


    @Override
    public LoanApplication getLoanApplicationById(int applicationId) {

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(
                            GET_LOAN_APPLICATION_BY_ID_SQL);

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

                logger.info("Loan application fetched successfully!");

                resultSet.close();
                statement.close();
                connection.close();

                return application;
            }

            logger.warn("Loan application not found for ID: {}",
                    applicationId);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while getting loan application.", e);
        }

        return null;
    }


    @Override
    public void updateLoanApplication(LoanApplication application) {

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(
                            UPDATE_LOAN_APPLICATION_SQL);

            statement.setInt(1, application.getCustomerId());
            statement.setInt(2, application.getLoanTypeId());
            statement.setDouble(3, application.getRequestedAmount());
            statement.setInt(4, application.getTenureMonths());
            statement.setString(5, application.getPurpose());
            statement.setString(6, application.getStatus());
            statement.setString(7, application.getRemarks());

            statement.setInt(8, application.getApplicationId());

            statement.executeUpdate();

            logger.info("Loan application updated successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while updating loan application.", e);
        }
    }


    @Override
    public void deleteLoanApplication(int applicationId) {

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(
                            DELETE_LOAN_APPLICATION_SQL);

            statement.setInt(1, applicationId);

            statement.executeUpdate();

            logger.info("Loan application deleted successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while deleting loan application.", e);
        }
    }
}