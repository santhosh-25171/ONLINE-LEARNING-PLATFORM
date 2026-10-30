package com.learning.CLI;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

final class CliInput {
    private CliInput() {
    }

    static String readLine(Scanner input, String prompt) {
        System.out.print(prompt);
        if (!input.hasNextLine()) {
            throw new EndOfInputException();
        }
        return input.nextLine();
    }

    static int readInt(Scanner input, String prompt) {
        while (true) {
            String value = readLine(input, prompt).trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException exception) {
                System.out.println("Enter a whole number.");
            }
        }
    }

    static double readDouble(Scanner input, String prompt) {
        while (true) {
            String value = readLine(input, prompt).trim();
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException exception) {
                System.out.println("Enter a number.");
            }
        }
    }

    static int readChoice(Scanner input, String prompt, int minimum, int maximum) {
        while (true) {
            int choice = readInt(input, prompt);
            if (choice >= minimum && choice <= maximum) {
                return choice;
            }
            System.out.println("Choose a number from " + minimum + " to " + maximum + ".");
        }
    }

    static boolean readBoolean(Scanner input, String prompt) {
        while (true) {
            String value = readLine(input, prompt).trim();
            if ("yes".equalsIgnoreCase(value) || "y".equalsIgnoreCase(value)
                    || "true".equalsIgnoreCase(value)) {
                return true;
            }
            if ("no".equalsIgnoreCase(value) || "n".equalsIgnoreCase(value)
                    || "false".equalsIgnoreCase(value)) {
                return false;
            }
            System.out.println("Enter yes or no.");
        }
    }

    static LocalDate readDate(Scanner input, String prompt, boolean blankAllowed,
                              LocalDate blankValue) {
        while (true) {
            String value = readLine(input, prompt).trim();
            if (value.isEmpty()) {
                if (blankAllowed) {
                    return blankValue;
                }
                System.out.println("A date is required.");
                continue;
            }
            try {
                return LocalDate.parse(value);
            } catch (DateTimeParseException exception) {
                System.out.println("Use the date format YYYY-MM-DD.");
            }
        }
    }

    static final class EndOfInputException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}
