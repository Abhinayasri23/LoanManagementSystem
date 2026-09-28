package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.LoanDao;
import com.loanmanagement.model.Loan;
import com.loanmanagement.util.DBConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanDaoImpl implements LoanDao {

    private static final Logger logger =
            LoggerFactory.getLogger(LoanDaoImpl.class);

    // ================= SQL QUERIES =================

    private static final String ADD_LOAN_SQL =
            "INSERT INTO loans " +
                    "(application_id, customer_id, loan_type_id, principal_amount, " +
                    "interest_rate, tenure_months, total_payable, outstanding_amount, " +
                    "start_date, status, created_by) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_LOAN_BY_ID_SQL =
            "SELECT * FROM loans WHERE loan_id = ?";

    private static final String UPDATE_LOAN_SQL =
            "UPDATE loans SET " +
                    "application_id = ?, customer_id = ?, loan_type_id = ?, " +
                    "principal_amount = ?, interest_rate = ?, tenure_months = ?, " +
                    "total_payable = ?, outstanding_amount = ?, start_date = ?, " +
                    "status = ?, created_by = ? " +
                    "WHERE loan_id = ?";

    private static final String DELETE_LOAN_SQL =
            "DELETE FROM loans WHERE loan_id = ?";


    // ================= ADD LOAN =================

    @Override
    public void addLoan(Loan loan) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(ADD_LOAN_SQL)) {

            statement.setInt(1, loan.getApplicationId());
            statement.setInt(2, loan.getCustomerId());
            statement.setInt(3, loan.getLoanTypeId());
            statement.setDouble(4, loan.getPrincipalAmount());
            statement.setDouble(5, loan.getInterestRate());
            statement.setInt(6, loan.getTenureMonths());
            statement.setDouble(7, loan.getTotalPayable());
            statement.setDouble(8, loan.getOutstandingAmount());
            statement.setString(9, loan.getStartDate());
            statement.setString(10, loan.getStatus());
            statement.setInt(11, loan.getCreatedBy());

            statement.executeUpdate();

            logger.info("Loan added successfully!");

        } catch (SQLException e) {

            logger.error("Error while adding loan.", e);

            throw new RuntimeException(
                    "Unable to add loan: " + e.getMessage(), e);
        }
    }


    // ================= GET LOAN =================

    @Override
    public Loan getLoanById(int loanId) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(GET_LOAN_BY_ID_SQL)) {

            statement.setInt(1, loanId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Loan loan = new Loan();

                    loan.setLoanId(
                            resultSet.getInt("loan_id"));

                    loan.setApplicationId(
                            resultSet.getInt("application_id"));

                    loan.setCustomerId(
                            resultSet.getInt("customer_id"));

                    loan.setLoanTypeId(
                            resultSet.getInt("loan_type_id"));

                    loan.setPrincipalAmount(
                            resultSet.getDouble("principal_amount"));

                    loan.setInterestRate(
                            resultSet.getDouble("interest_rate"));

                    loan.setTenureMonths(
                            resultSet.getInt("tenure_months"));

                    loan.setTotalPayable(
                            resultSet.getDouble("total_payable"));

                    loan.setOutstandingAmount(
                            resultSet.getDouble("outstanding_amount"));

                    loan.setStartDate(
                            resultSet.getString("start_date"));

                    loan.setStatus(
                            resultSet.getString("status"));

                    loan.setCreatedBy(
                            resultSet.getInt("created_by"));

                    logger.info("Loan fetched successfully!");

                    return loan;
                }
            }

            logger.warn(
                    "Loan not found for ID: {}",
                    loanId);

            return null;

        } catch (SQLException e) {

            logger.error(
                    "Error while getting loan.",
                    e);

            throw new RuntimeException(
                    "Unable to get loan: " + e.getMessage(), e);
        }
    }


    // ================= UPDATE LOAN =================

    @Override
    public void updateLoan(Loan loan) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(UPDATE_LOAN_SQL)) {

            statement.setInt(1, loan.getApplicationId());
            statement.setInt(2, loan.getCustomerId());
            statement.setInt(3, loan.getLoanTypeId());
            statement.setDouble(4, loan.getPrincipalAmount());
            statement.setDouble(5, loan.getInterestRate());
            statement.setInt(6, loan.getTenureMonths());
            statement.setDouble(7, loan.getTotalPayable());
            statement.setDouble(8, loan.getOutstandingAmount());
            statement.setString(9, loan.getStartDate());
            statement.setString(10, loan.getStatus());
            statement.setInt(11, loan.getCreatedBy());
            statement.setInt(12, loan.getLoanId());

            statement.executeUpdate();

            logger.info("Loan updated successfully!");

        } catch (SQLException e) {

            logger.error(
                    "Error while updating loan.",
                    e);

            throw new RuntimeException(
                    "Unable to update loan: " + e.getMessage(), e);
        }
    }


    // ================= DELETE LOAN =================

    @Override
    public void deleteLoan(int loanId) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(DELETE_LOAN_SQL)) {

            statement.setInt(1, loanId);

            statement.executeUpdate();

            logger.info("Loan deleted successfully!");

        } catch (SQLException e) {

            logger.error(
                    "Error while deleting loan.",
                    e);

            throw new RuntimeException(
                    "Unable to delete loan: " + e.getMessage(), e);
        }
    }
}