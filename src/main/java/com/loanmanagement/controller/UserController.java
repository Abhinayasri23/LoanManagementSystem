package com.loanmanagement.controller;

import com.loanmanagement.model.User;
import com.loanmanagement.service.UserService;
import com.loanmanagement.service.impl.UserServiceImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.util.InputUtil;

import java.util.Scanner;

public class UserController {

    private UserService userService =
            new UserServiceImpl();


    // ================= USER MENU =================

    public void userMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("========== USER MANAGEMENT ==========");
            System.out.println("1. Add User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Back");

            int choice =
                    InputUtil.readInt(
                            scanner,
                            "Enter choice: ");

            switch (choice) {

                case 1:
                    addUser(scanner);
                    break;

                case 2:
                    getUser(scanner);
                    break;

                case 3:
                    updateUser(scanner);
                    break;

                case 4:
                    deleteUser(scanner);
                    break;

                case 5:
                    return;

                default:
                    System.out.println();
                    System.out.println(
                            "Invalid choice!");

                    System.out.println(
                            "Please enter a valid option.");
            }
        }
    }


    // ================= ADD USER =================

    private void addUser(Scanner scanner) {

        while (true) {

            try {

                User user = new User();

                user.setUsername(
                        InputUtil.readString(
                                scanner,
                                "Enter Username: "));

                user.setPassword(
                        InputUtil.readString(
                                scanner,
                                "Enter Password: "));

                user.setRole(
                        InputUtil.readString(
                                scanner,
                                "Enter Role: "));

                user.setStatus(
                        InputUtil.readString(
                                scanner,
                                "Enter Status: "));

                user.setCreatedAt(
                        InputUtil.readString(
                                scanner,
                                "Enter Created At: "));

                userService.addUser(user);

                System.out.println();
                System.out.println(
                        "User added successfully!");

                break;

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "User could not be added!");

                System.out.println(
                        "Please enter the details again.");
            }
        }
    }


    // ================= VIEW USER =================

    private void getUser(Scanner scanner) {

        while (true) {

            int userId =
                    InputUtil.readInt(
                            scanner,
                            "Enter User ID: ");

            try {

                User user =
                        userService.getUserById(
                                userId);

                System.out.println();
                System.out.println(
                        "========== USER DETAILS ==========");

                System.out.println(
                        "User ID    : "
                                + user.getUserId());

                System.out.println(
                        "Username   : "
                                + user.getUsername());

                System.out.println(
                        "Password   : ********");

                System.out.println(
                        "Role       : "
                                + user.getRole());

                System.out.println(
                        "Status     : "
                                + user.getStatus());

                System.out.println(
                        "Created At : "
                                + user.getCreatedAt());

                System.out.println(
                        "==================================");

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "User not found!");

                System.out.println(
                        "Please enter User ID again.");
            }
        }
    }


    // ================= UPDATE USER =================

    private void updateUser(Scanner scanner) {

        while (true) {

            int userId =
                    InputUtil.readInt(
                            scanner,
                            "Enter User ID: ");

            try {

                User user =
                        userService.getUserById(
                                userId);

                System.out.println();
                System.out.println("1. Username");
                System.out.println("2. Password");
                System.out.println("3. Role");
                System.out.println("4. Status");
                System.out.println("5. Cancel");

                int choice =
                        InputUtil.readInt(
                                scanner,
                                "Enter field choice: ");

                switch (choice) {

                    case 1:

                        user.setUsername(
                                InputUtil.readString(
                                        scanner,
                                        "New Username: "));

                        break;

                    case 2:

                        user.setPassword(
                                InputUtil.readString(
                                        scanner,
                                        "New Password: "));

                        break;

                    case 3:

                        user.setRole(
                                InputUtil.readString(
                                        scanner,
                                        "New Role: "));

                        break;

                    case 4:

                        user.setStatus(
                                InputUtil.readString(
                                        scanner,
                                        "New Status: "));

                        break;

                    case 5:

                        System.out.println(
                                "Update cancelled.");

                        return;

                    default:

                        System.out.println();
                        System.out.println(
                                "Invalid choice!");

                        System.out.println(
                                "Please enter a valid option.");

                        continue;
                }

                userService.updateUser(user);

                System.out.println();
                System.out.println(
                        "User updated successfully!");

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "User not found!");

                System.out.println(
                        "Please enter User ID again.");

            } catch (RuntimeException e) {

                System.out.println();
                System.out.println(
                        "Update failed!");

                System.out.println(
                        "Please check the entered values.");

                System.out.println(
                        "Please try again.");
            }
        }
    }


    // ================= DELETE USER =================

    private void deleteUser(Scanner scanner) {

        while (true) {

            int userId =
                    InputUtil.readInt(
                            scanner,
                            "Enter User ID: ");

            try {

                userService.getUserById(
                        userId);

                String answer =
                        InputUtil.readString(
                                scanner,
                                "Delete? yes/no: ");

                if (answer.equalsIgnoreCase("yes")) {

                    userService.deleteUser(
                            userId);

                    System.out.println();
                    System.out.println(
                            "User deleted successfully!");

                } else {

                    System.out.println();
                    System.out.println(
                            "Delete cancelled.");
                }

                break;

            } catch (NotFoundException e) {

                System.out.println();
                System.out.println(
                        "User not found!");

                System.out.println(
                        "Please enter User ID again.");
            }
        }
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        UserController controller =
                new UserController();

        controller.userMenu();
    }
}