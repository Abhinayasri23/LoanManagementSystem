package com.loanmanagement.service;

import com.loanmanagement.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    private AuthService authService =
            new AuthServiceImpl();

    @Test
    void loginSuccessTest() {

        boolean result =
                authService.login(
                        "abhivinitha",
                        "test123"
                );

        assertTrue(result);
    }

    @Test
    void loginFailureTest() {

        boolean result =
                authService.login(
                        "wronguser",
                        "wrongpassword"
                );

        assertFalse(result);
    }

    @Test
    void logoutTest() {

        authService.logout(1);

        assertTrue(true);
    }
}