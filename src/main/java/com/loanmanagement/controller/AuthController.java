package com.loanmanagement.controller;

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

    public void login() {

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

                boolean result =
                        authService.login(
                                username,
                                password);

                if (result) {

                    System.out.println();
                    System.out.println(
                            "Login successful!");

                    logger.info(
                            "Login successful!");

                    break;

                } else {

                    System.out.println();
                    System.out.println(
                            "Invalid username or password!");

                    System.out.println(
                            "Please enter again.");

                    logger.warn(
                            "Login failed!");
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

    public void logout() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int userId =
                    InputUtil.readInt(
                            scanner,
                            "Enter User ID: ");

            try {

                authService.logout(userId);

                System.out.println();
                System.out.println(
                        "Logout successful!");

                logger.info(
                        "Logout completed!");

                break;

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Logout failed!");

                System.out.println(
                        "Please enter User ID again.");
            }
        }
    }

    public static void main(String[] args) {

        AuthController authController =
                new AuthController();

        authController.login();
    }
}