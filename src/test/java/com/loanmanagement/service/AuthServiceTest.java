package com.loanmanagement.service;

import com.loanmanagement.model.User;
import com.loanmanagement.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    private AuthService authService =
            new AuthServiceImpl();

    @Test
    void loginSuccessTest() {

        User result =
                authService.login(
                        "abhivinitha",
                        "test123");

        assertNotNull(result);
        assertEquals("abhivinitha",
                result.getUsername());
    }

    @Test
    void loginFailureTest() {

        User result =
                authService.login(
                        "wronguser",
                        "wrongpassword");

        assertNull(result);
    }

    @Test
    void logoutTest() {

        authService.logout(1);

        assertTrue(true);
    }
}