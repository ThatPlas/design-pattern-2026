package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;

public class UndoActionHandler implements MenuHandler{
    @Override
    public void execute(GameCollection collection) {
        GameService.undoLastAction(collection);
    }
}
