package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;

public class ViewSummaryHandler implements MenuHandler{
    @Override
    public void execute(GameCollection collection) {
        GameService.summaryGames(collection);
    }
}
