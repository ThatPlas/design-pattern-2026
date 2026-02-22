package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GamePrinter;

public class ViewSummaryHandler implements MenuHandler{

    /**
     * Executes the view summary handler by displaying a summary of games.
     *
     * @param collection the game collection to display summary for
     */
    @Override
    public void execute(GameCollection collection) {
        GamePrinter gamePrinter = new GamePrinter(collection);
        gamePrinter.summaryGames();
    }
}
