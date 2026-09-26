package com.loanmanagement.service.impl;

import com.loanmanagement.dao.UserDao;
import com.loanmanagement.dao.impl.UserDaoImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.User;
import com.loanmanagement.service.UserService;
import com.loanmanagement.util.ValidationUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {

        ValidationUtil.validateNotEmpty(
                user.getUsername(), "Username");

        ValidationUtil.validateNotEmpty(
                user.getPassword(), "Password");

        ValidationUtil.validateNotEmpty(
                user.getRole(), "Role");

        ValidationUtil.validateNotEmpty(
                user.getStatus(), "Status");

        userDao.addUser(user);
    }

    @Override
    public User getUserById(int userId) {

        ValidationUtil.validatePositive(
                userId, "User ID");

        User user = userDao.getUserById(userId);

        if (user == null) {
            throw new NotFoundException(
                    "User not found with ID: " + userId);
        }

        return user;
    }

    @Override
    public void updateUser(User user) {

        ValidationUtil.validatePositive(
                user.getUserId(), "User ID");

        ValidationUtil.validateNotEmpty(
                user.getUsername(), "Username");

        ValidationUtil.validateNotEmpty(
                user.getPassword(), "Password");

        ValidationUtil.validateNotEmpty(
                user.getRole(), "Role");

        ValidationUtil.validateNotEmpty(
                user.getStatus(), "Status");

        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {

        ValidationUtil.validatePositive(
                userId, "User ID");

        userDao.deleteUser(userId);
    }
}