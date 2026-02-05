package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;

public class RecommandGameHandler implements MenuHandler{
    @Override
    public void execute(GameCollection collection) {
        GameService.recommendGame(collection);
    }
}
