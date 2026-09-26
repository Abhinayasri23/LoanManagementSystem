package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.LoanTypeDao;
import com.loanmanagement.model.LoanType;
import com.loanmanagement.util.DBConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanTypeDaoImpl implements LoanTypeDao {

    private static final Logger logger =
            LoggerFactory.getLogger(LoanTypeDaoImpl.class);

    // SQL Queries
    private static final String ADD_LOAN_TYPE_SQL =
            "INSERT INTO loan_types " +
                    "(name, description, interest_rate, min_amount, max_amount, max_tenure_months, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_LOAN_TYPE_BY_ID_SQL =
            "SELECT * FROM loan_types WHERE loan_type_id = ?";

    private static final String UPDATE_LOAN_TYPE_SQL =
            "UPDATE loan_types SET " +
                    "name = ?, description = ?, interest_rate = ?, " +
                    "min_amount = ?, max_amount = ?, max_tenure_months = ?, " +
                    "status = ? " +
                    "WHERE loan_type_id = ?";

    private static final String DELETE_LOAN_TYPE_SQL =
            "DELETE FROM loan_types WHERE loan_type_id = ?";


    @Override
    public void addLoanType(LoanType loanType) {

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(ADD_LOAN_TYPE_SQL);

            statement.setString(1, loanType.getName());
            statement.setString(2, loanType.getDescription());
            statement.setDouble(3, loanType.getInterestRate());
            statement.setDouble(4, loanType.getMinAmount());
            statement.setDouble(5, loanType.getMaxAmount());
            statement.setInt(6, loanType.getMaxTenureMonths());
            statement.setString(7, loanType.getStatus());

            statement.executeUpdate();

            logger.info("Loan type added successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while adding loan type.", e);
        }
    }

    @Override
    public LoanType getLoanTypeById(int loanTypeId) {

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(GET_LOAN_TYPE_BY_ID_SQL);

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

                logger.info("Loan type fetched successfully!");

                resultSet.close();
                statement.close();
                connection.close();

                return loanType;
            }

            logger.warn("Loan type not found for ID: {}", loanTypeId);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while getting loan type.", e);
        }

        return null;
    }

    @Override
    public void updateLoanType(LoanType loanType) {

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(UPDATE_LOAN_TYPE_SQL);

            statement.setString(1, loanType.getName());
            statement.setString(2, loanType.getDescription());
            statement.setDouble(3, loanType.getInterestRate());
            statement.setDouble(4, loanType.getMinAmount());
            statement.setDouble(5, loanType.getMaxAmount());
            statement.setInt(6, loanType.getMaxTenureMonths());
            statement.setString(7, loanType.getStatus());
            statement.setInt(8, loanType.getLoanTypeId());

            statement.executeUpdate();

            logger.info("Loan type updated successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while updating loan type.", e);
        }
    }

    @Override
    public void deleteLoanType(int loanTypeId) {

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(DELETE_LOAN_TYPE_SQL);

            statement.setInt(1, loanTypeId);

            statement.executeUpdate();

            logger.info("Loan type deleted successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while deleting loan type.", e);
        }
    }
}