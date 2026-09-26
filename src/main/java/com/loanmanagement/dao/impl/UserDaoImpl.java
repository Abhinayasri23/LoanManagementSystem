package com.loanmanagement.dao.impl;

import com.loanmanagement.dao.UserDao;
import com.loanmanagement.model.User;
import com.loanmanagement.util.DBConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final Logger logger =
            LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void addUser(User user) {

        String sql = "INSERT INTO users " +
                "(username, password, role, status, created_at) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setString(4, user.getStatus());
            statement.setString(5, user.getCreatedAt());

            statement.executeUpdate();

            logger.info("User added successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while adding user.", e);
        }
    }

    @Override
    public User getUserById(int userId) {

        String sql = "SELECT * FROM users WHERE user_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                User user = new User();

                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setStatus(resultSet.getString("status"));
                user.setCreatedAt(resultSet.getString("created_at"));

                logger.info("User fetched successfully!");

                resultSet.close();
                statement.close();
                connection.close();

                return user;
            }

            logger.warn("User not found for ID: {}", userId);

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while getting user.", e);
        }

        return null;
    }

    @Override
    public void updateUser(User user) {

        String sql = "UPDATE users SET " +
                "username = ?, password = ?, role = ?, status = ? " +
                "WHERE user_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setString(4, user.getStatus());
            statement.setInt(5, user.getUserId());

            statement.executeUpdate();

            logger.info("User updated successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while updating user.", e);
        }
    }

    @Override
    public void deleteUser(int userId) {

        String sql = "DELETE FROM users WHERE user_id = ?";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);

            statement.executeUpdate();

            logger.info("User deleted successfully!");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.error("Error while deleting user.", e);
        }
    }
}