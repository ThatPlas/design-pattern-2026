package fr.fges;

import java.util.Scanner;

public class MenuController {

    public static void handleMenu() {
        MenuView.displayMainMenu();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> GameService.addGame();
            case "2" -> GameService.removeGame();
            case "3" -> GameService.listGames();
            case "4" -> exit();
            default -> MenuView.showMessage("Invalid choice.");
        }
    }

    private static void exit() {
        MenuView.showMessage("Exiting the application. Goodbye!");
        System.exit(0);
    }
}
