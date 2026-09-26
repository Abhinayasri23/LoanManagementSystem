package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.RepaymentDao;
import com.loanmanagement.model.Repayment;
import com.loanmanagement.util.DBConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepaymentDaoImpl implements RepaymentDao {

    private static final Logger logger =
            LoggerFactory.getLogger(RepaymentDaoImpl.class);

    @Override
    public void addRepayment(Repayment repayment) {

        String sql = "INSERT INTO repayments " +
                "(loan_id, amount, payment_date, payment_mode, reference_no, " +
                "remarks, recorded_by, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, repayment.getLoanId());
            statement.setDouble(2, repayment.getAmount());
            statement.setString(3, repayment.getPaymentDate());
            statement.setString(4, repayment.getPaymentMode());
            statement.setString(5, repayment.getReferenceNo());
            statement.setString(6, repayment.getRemarks());
            statement.setInt(7, repayment.getRecordedBy());
            statement.setString(8, repayment.getCreatedAt());

            statement.executeUpdate();

            logger.info("Repayment added successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while adding repayment.", e);
        }
    }

    @Override
    public Repayment getRepaymentById(int repaymentId) {

        String sql = "SELECT * FROM repayments WHERE repayment_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, repaymentId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Repayment repayment = new Repayment();

                repayment.setRepaymentId(
                        resultSet.getInt("repayment_id"));
                repayment.setLoanId(
                        resultSet.getInt("loan_id"));
                repayment.setAmount(
                        resultSet.getDouble("amount"));
                repayment.setPaymentDate(
                        resultSet.getString("payment_date"));
                repayment.setPaymentMode(
                        resultSet.getString("payment_mode"));
                repayment.setReferenceNo(
                        resultSet.getString("reference_no"));
                repayment.setRemarks(
                        resultSet.getString("remarks"));
                repayment.setRecordedBy(
                        resultSet.getInt("recorded_by"));
                repayment.setCreatedAt(
                        resultSet.getString("created_at"));

                logger.info("Repayment fetched successfully!");

                resultSet.close();
                statement.close();
                connection.close();

                return repayment;
            }

            logger.warn("Repayment not found for ID: {}", repaymentId);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while getting repayment.", e);
        }

        return null;
    }

    @Override
    public void updateRepayment(Repayment repayment) {

        String sql = "UPDATE repayments SET " +
                "loan_id = ?, amount = ?, payment_date = ?, " +
                "payment_mode = ?, reference_no = ?, remarks = ?, " +
                "recorded_by = ?, created_at = ? " +
                "WHERE repayment_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, repayment.getLoanId());
            statement.setDouble(2, repayment.getAmount());
            statement.setString(3, repayment.getPaymentDate());
            statement.setString(4, repayment.getPaymentMode());
            statement.setString(5, repayment.getReferenceNo());
            statement.setString(6, repayment.getRemarks());
            statement.setInt(7, repayment.getRecordedBy());
            statement.setString(8, repayment.getCreatedAt());
            statement.setInt(9, repayment.getRepaymentId());

            statement.executeUpdate();

            logger.info("Repayment updated successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while updating repayment.", e);
        }
    }

    @Override
    public void deleteRepayment(int repaymentId) {

        String sql = "DELETE FROM repayments WHERE repayment_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, repaymentId);

            statement.executeUpdate();

            logger.info("Repayment deleted successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while deleting repayment.", e);
        }
    }
}