package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GamePrinter;

public class ListGameHandler implements MenuHandler{

    /**
     * Executes the list game handler by displaying all games in the collection.
     *
     * @param collection the game collection to display
     */
    @Override
    public void execute(GameCollection collection) {
        GamePrinter gamePrinter = new GamePrinter(collection);
        gamePrinter.viewAllGames();
    }
}
