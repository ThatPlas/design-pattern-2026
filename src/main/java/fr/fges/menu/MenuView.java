package fr.fges.menu;

import fr.fges.menu.options.MenuOption;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Renders menu and status output to the console.
 */
public class MenuView {

    /**
     * Displays the main menu options.
     */

    public static void displayMainMenu(List<String> options){

        System.out.println("");
        System.out.println("=== Board Game Collection ===");

        for(int i = 0; i < options.size(); i++){
            String option = options.get(i);
            System.out.println(i+1 + ". " + option);
        }

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
