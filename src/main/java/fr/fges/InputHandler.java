package fr.fges;

import java.util.Scanner;
//Lecture des entrées USER
public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String ask(String prompt) {
        System.out.printf("%s: ", prompt);
        return scanner.nextLine();
    }
}
