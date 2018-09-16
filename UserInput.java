import java.util.Scanner;

/**
 * @author Ryan Stewart
 * @version 1.0
 *
 * This is a final class UserInput
 *
 * Static features:
 * - Get a valid positive integer
 * - Get a valid positive double
 * - Get a valid integer within a specified range
 * - Get non-empty input text from the user
 * - Get a boolean based on if user typed 'y' / 'yes'
 * - Get a boolean based on if user typed 'exit'
 */
public final class UserInput {
    // Static scanner instance
    private static Scanner input = new Scanner(System.in);

    /**
     * Get a valid number from the user
     * @param message to be printed
     * @return int gotten from user input
     */
    public static int getInputInt(String message) {
        // Keep going until valid input has been achieved
        while (true) {
            // Get user input, checking if it's empty or not
            String userInput = getInputText(message);

            // Try to parse the int
            try {
                int number = Integer.parseInt(userInput);

                // Check if it's a positive number
                if (number > 0)
                    // Return the number
                    return number;
                else
                    // Print an error message
                    Print.error(number + " is not positive");

            // Catch the formatting exception
            } catch (NumberFormatException e) {
                Print.error("Not a valid integer");
            }
        }
    }

    /**
     * Get a valid number from the user
     * @param message to be printed
     * @return double gotten from user input
     */
    public static double getInputDouble(String message) {
        // Keep going until valid input has been achieved
        while (true) {
            // Get user input, checking if it's empty or not
            String userInput = getInputText(message);

            // Try parsing the string to Double
            try {
                // Parse string to double
                double number = Double.parseDouble(userInput);

                // Number must be positive
                if (number > 0)
                    return number;
                else
                    // Print error message
                    Print.error(number + " is not a positive number");
            // Catch the parse exception
            } catch (NumberFormatException e) {
                // The user input was not a valid double
                Print.error("Not a valid number");
            }
        }
    }

    /**
     * Get integer within given range
     * @param from minimum number
     * @param to maximum number
     * @return number within given range
     */
    public static int getIntInRange(int from, int to) {
        // Keep going until valid input is achieved
        while (true) {
            // Check if the user has input a valid int
            int number = getInputInt("Enter a number between " + from + "-" + to + ": ");

            // Check if the int is between the provided range
            if (number >= from && number <= to)
                return number;
            else
                // Print error if not
                Print.error(number + " is not between " + from + " and " + to + ".");
        }
    }

    /**
     * Get a line of text from the user
     * @param message to be printed
     * @return user input String
     */
    public static String getInputText(String message) {
        // Loop until a non-empty string entered
        while (true) {
            // Print message
            Print.print(message);

            // Get user input string
            String userInput = input.nextLine();

            // Check if the user has input a valid text
            if (!userInput.isEmpty())
                // Return the non-empty string
                return userInput;
            else
                // Print error message
                Print.error("You did not enter anything.");
        }
    }

    /**
     * Ask user for yes/no input
     * @param message to be printed
     * @return boolean corresponding to user's input
     */
    public static boolean getInputBoolean(String message) {
        // Print message
        Print.print(message);

        // Get user input string
        String userInput = input.nextLine();

        // Return true if user entered 'yes' or 'y' disregarding case
        return (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y"));
    }

    /**
     * Ask user if they wish to continue or to exit
     * @return boolean corresponding to user input
     */
    public static boolean getExitStatus() {
        // Print message
        Print.println(Colour.blue("\nPress \u21B5 to continue. Type 'exit' to finish.\n", true));

        // Return boolean of whether user entered 'exit' or not
        return !input.nextLine().equalsIgnoreCase("exit");
    }
}