package com.loanmanagement.service;

public interface AuthService {
    boolean login(String username, String password);

    void logout(int userId);
}
