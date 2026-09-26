package com.loanmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {

    private static final Logger logger =
            LoggerFactory.getLogger(DBConnection.class);

    private static final String URL =
            "jdbc:mysql://localhost:3306/lms_db";

    private static final String USERNAME = "root";

    private static final String PASSWORD =
            "1234";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            logger.info("Database connected successfully!");

        } catch (SQLException e) {
            logger.error("Database connection failed!", e);
        }

        return connection;
    }
}