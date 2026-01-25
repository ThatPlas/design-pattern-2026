package fr.fges;

/**
 * Renders menu and status output to the console.
 */
public class MenuView {

    /**
     * Displays the main menu options.
     */
    public static void displayMainMenu() {
        System.out.println("""
                === Board Game Collection ===
                1. Add Board Game
                2. Remove Board Game
                3. List All Board Games
                4. Exit
                Please select an option (1-4):
                """);
    }

    /**
     * Prints a message to the console.
     *
     * @param message message to display
     */
    public static void showMessage(String message) {
        System.out.println(message);
    }
}
