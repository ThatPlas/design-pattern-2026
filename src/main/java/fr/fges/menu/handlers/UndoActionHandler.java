package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

public class UndoActionHandler implements MenuHandler{

    private GameService gameService;

    public UndoActionHandler(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public void execute(GameCollection collection) {
        this.gameService.undoLastAction(collection);
        MenuView.showMessage("Last action reverted successfully.");
    }
}
