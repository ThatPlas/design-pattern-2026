package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GamePrinter;
import fr.fges.game.GameService;

public class ViewSummaryHandler implements MenuHandler{

    @Override
    public void execute(GameCollection collection) {
        GamePrinter gamePrinter = new GamePrinter(collection);
        gamePrinter.summaryGames();
    }
}
