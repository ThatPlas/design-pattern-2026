package fr.fges;

import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static void setInput(InputStream input) {
        scanner = new Scanner(input);
    }

    public static void resetScanner() {
        scanner = new Scanner(System.in);
    }

    public static String ask(String prompt) {
        System.out.printf("%s: ", prompt);
        return scanner.nextLine();
    }
}
