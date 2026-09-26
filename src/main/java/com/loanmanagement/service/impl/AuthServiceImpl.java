package com.loanmanagement.service.impl;

import com.loanmanagement.service.AuthService;
import com.loanmanagement.util.DBConnection;
import com.loanmanagement.util.ValidationUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthServiceImpl implements AuthService {

    private static final Logger logger =
            LoggerFactory.getLogger(AuthServiceImpl.class);

    private static final String LOGIN_SQL =
            "SELECT * FROM users WHERE username = ? AND password = ?";

    @Override
    public boolean login(String username, String password) {

        ValidationUtil.validateNotEmpty(
                username, "Username");

        ValidationUtil.validateNotEmpty(
                password, "Password");

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(LOGIN_SQL)) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet =
                    statement.executeQuery();

            if (resultSet.next()) {

                logger.info(
                        "User login successful: {}",
                        username);

                return true;

            } else {

                logger.warn(
                        "Login failed for username: {}",
                        username);

                return false;
            }

        } catch (SQLException e) {

            logger.error(
                    "Login failed due to database error",
                    e);

            return false;
        }
    }

    @Override
    public void logout(int userId) {

        ValidationUtil.validatePositive(
                userId, "User ID");

        logger.info(
                "User logged out successfully: {}",
                userId);
    }
}