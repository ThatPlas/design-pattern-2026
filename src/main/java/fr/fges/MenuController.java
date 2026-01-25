package fr.fges;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;

import java.util.Scanner;

public class MenuController {

    public static void handleMenu(GameCollection collection) {
        MenuView.displayMainMenu();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> GameService.addGame(collection);
            case "2" -> GameService.removeGame(collection);
            case "3" -> GameService.listGames(collection);
            case "4" -> exit();
            default -> MenuView.showMessage("Invalid choice.");
        }
    }

    private static void exit() {
        MenuView.showMessage("Exiting the application. Goodbye!");
        System.exit(0);
    }
}
