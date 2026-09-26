package com.loanmanagement.service;

import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.User;
import com.loanmanagement.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService =
            new UserServiceImpl();

    @Test
    void getUserByIdTest() {

        User user =
                userService.getUserById(1);

        assertNotNull(user);
        assertEquals(1, user.getUserId());
    }

    @Test
    void updateUserTest() {

        User user =
                userService.getUserById(1);

        assertNotNull(user);

        user.setStatus("ACTIVE");

        userService.updateUser(user);

        User updatedUser =
                userService.getUserById(1);

        assertEquals(
                "ACTIVE",
                updatedUser.getStatus()
        );
    }

    @Test
    void getUserByIdNotFoundTest() {

        assertThrows(
                NotFoundException.class,
                () -> userService.getUserById(999)
        );
    }
}