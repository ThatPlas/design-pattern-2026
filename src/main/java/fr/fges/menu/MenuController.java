package fr.fges.menu;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;
import java.util.*;

/**
 * Handles user choices from the main menu.
 */
public class MenuController {

    private final GameService gameService;

    /**
     * Constructs a MenuController with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public MenuController(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Displays the menu and dispatches the user's selection.
     *
     * @param collection game collection to operate on
     */

    public void handleMenu(GameCollection collection) {
        MenuCreator menuCreator = new MenuCreator(this.gameService);
        Map<String, Integer> availableOptions = menuCreator.getAvailableOptions(LocalDate.now());
        List<String> optionsList = new ArrayList<>(availableOptions.keySet());

        MenuView.displayMainMenu(optionsList);

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if(!isValidChoice(choice, optionsList)){
            MenuView.showMessage("Invalid choice. Please try again.");
            return;
        }

        menuCreator.getOption(availableOptions.get(optionsList.get(Integer.parseInt(choice) - 1))).getHandler().execute(collection);
    }

    /**
     * Validates if the user's choice is a valid menu option.
     *
     * @param option the user's choice as string
     * @param currentOptions the list of available options
     * @return true if the choice is valid, false otherwise
     */
    private boolean isValidChoice(String option, List<String> currentOptions){

        try{
            Integer.parseInt(option);
        }catch(NumberFormatException e){
            return false;
        }

        return Integer.parseInt(option) <= currentOptions.size() && Integer.parseInt(option) >= 1;

    }

}
