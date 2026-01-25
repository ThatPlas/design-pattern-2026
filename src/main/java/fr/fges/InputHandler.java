package fr.fges;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Reads user input from the configured input stream.
 */
public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Replaces the input source used by the handler.
     *
     * @param input input stream to read from
     */
    public static void setInput(InputStream input) {
        scanner = new Scanner(input);
    }

    /**
     * Resets the input source back to standard input.
     */
    public static void resetScanner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user and reads a line of input.
     *
     * @param prompt text to display before reading
     * @return the line entered by the user
     */
    public static String ask(String prompt) {
        System.out.printf("%s: ", prompt);
        return scanner.nextLine();
    }
}
