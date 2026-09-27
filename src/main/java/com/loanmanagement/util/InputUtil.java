
package com.loanmanagement.util;

import java.util.Scanner;

public class InputUtil {

    // Read Integer
    public static int readInt(
            Scanner scanner,
            String message) {

        while (true) {

            try {

                System.out.print(message);

                String input =
                        scanner.nextLine();

                return Integer.parseInt(
                        input.trim());

            } catch (NumberFormatException e) {

                System.out.println();
                System.out.println(
                        "Invalid input!");
                System.out.println(
                        "Please enter a valid number.");
                System.out.println();
            }
        }
    }


    // Read Double
    public static double readDouble(
            Scanner scanner,
            String message) {

        while (true) {

            try {

                System.out.print(message);

                String input =
                        scanner.nextLine();

                return Double.parseDouble(
                        input.trim());

            } catch (NumberFormatException e) {

                System.out.println();
                System.out.println(
                        "Invalid input!");
                System.out.println(
                        "Please enter a valid number.");
                System.out.println();
            }
        }
    }


    // Read String
    public static String readString(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine();

            if (!input.trim().isEmpty()) {

                return input.trim();
            }

            System.out.println();
            System.out.println(
                    "Input cannot be empty!");
            System.out.println(
                    "Please enter a valid value.");
            System.out.println();
        }
    }
}