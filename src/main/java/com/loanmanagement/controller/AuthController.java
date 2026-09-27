package com.loanmanagement.controller;

import com.loanmanagement.service.AuthService;
import com.loanmanagement.service.impl.AuthServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthController {

    private static final Logger logger =
            LoggerFactory.getLogger(AuthController.class);

    private AuthService authService =
            new AuthServiceImpl();

    // Login
    public void login(String username, String password) {

        boolean result =
                authService.login(username, password);

        if (result) {
            logger.info("Login successful!");
        } else {
            logger.warn("Login failed!");
        }
    }

    // Logout
    public void logout(int userId) {

        authService.logout(userId);

        logger.info("Logout completed!");
    }

    // Main method for testing
    public static void main(String[] args) {

        AuthController authController =
                new AuthController();

        // Test login
        authController.login(
                "abhivinitha",
                "test123"
        );

        // Test logout
        authController.logout(1);
    }
}