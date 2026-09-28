package com.loanmanagement.controller;

import com.loanmanagement.model.User;
import com.loanmanagement.service.AuthService;
import com.loanmanagement.service.impl.AuthServiceImpl;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthController {

    private static final Logger logger =
            LoggerFactory.getLogger(AuthController.class);

    private AuthService authService =
            new AuthServiceImpl();


    // ================= LOGIN =================

    public User login() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("========== LOGIN ==========");

            String username =
                    InputUtil.readString(
                            scanner,
                            "Enter Username: ");

            String password =
                    InputUtil.readString(
                            scanner,
                            "Enter Password: ");

            try {

                User user =
                        authService.login(
                                username,
                                password);


                if (user != null) {

                    System.out.println();
                    System.out.println(
                            "Login successful!");

                    System.out.println(
                            "Welcome, "
                                    + user.getUsername()
                                    + "!");

                    System.out.println(
                            "Role: "
                                    + user.getRole());

                    logger.info(
                            "Login successful for user: {}",
                            username);

                    return user;

                } else {

                    System.out.println();
                    System.out.println(
                            "Invalid username or password!");

                    System.out.println(
                            "Please enter again.");

                    logger.warn(
                            "Login failed for username: {}",
                            username);
                }


            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Login failed!");

                System.out.println(
                        "Please enter again.");
            }
        }
    }


    // ================= LOGOUT =================

    public void logout(User user) {

        if (user == null) {
            return;
        }

        try {

            authService.logout(
                    user.getUserId());

            System.out.println();
            System.out.println(
                    "Logout successful!");

            logger.info(
                    "Logout completed for user: {}",
                    user.getUsername());


        } catch (RuntimeException e) {

            System.out.println();
            System.out.println(
                    "Logout failed!");

            System.out.println(
                    "Please try again.");
        }
    }
}