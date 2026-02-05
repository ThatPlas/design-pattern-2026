package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;

public class RemoveGameHandler implements MenuHandler{
    @Override
    public void execute(GameCollection collection) {
        GameService.removeGame(collection);
    }
}
