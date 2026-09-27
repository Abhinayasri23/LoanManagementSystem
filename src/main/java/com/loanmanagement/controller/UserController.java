package com.loanmanagement.controller;

import com.loanmanagement.model.User;
import com.loanmanagement.service.UserService;
import com.loanmanagement.service.impl.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    private UserService userService =
            new UserServiceImpl();

    public void testUser() {

        User user =
                userService.getUserById(1);

        if (user != null) {

            logger.info("User fetched successfully!");

            user.setStatus("ACTIVE");

            userService.updateUser(user);

            logger.info("User update completed!");

        } else {

            logger.warn("User not found!");

        }
    }

    public static void main(String[] args) {

        UserController userController =
                new UserController();

        userController.testUser();
    }
}