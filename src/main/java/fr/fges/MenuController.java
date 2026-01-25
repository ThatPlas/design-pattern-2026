package fr.fges;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;

import java.util.Scanner;

/**
 * Handles user choices from the main menu.
 */
public class MenuController {

    /**
     * Displays the menu and dispatches the user's selection.
     *
     * @param collection game collection to operate on
     */
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

    /**
     * Terminates the application.
     */
    private static void exit() {
        MenuView.showMessage("Exiting the application. Goodbye!");
        System.exit(0);
    }
}
