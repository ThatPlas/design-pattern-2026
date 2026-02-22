package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

public class UndoActionHandler implements MenuHandler{

    private final GameService gameService;

    /**
     * Constructs an UndoActionHandler with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public UndoActionHandler(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Executes the undo action handler by reverting the last action.
     *
     * @param collection the game collection to revert the last action on
     */
    @Override
    public void execute(GameCollection collection) {
        this.gameService.undoLastAction(collection);
        MenuView.showMessage("Last action reverted successfully.");
    }
}
