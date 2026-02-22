package fr.fges.menu.handlers;

import fr.fges.InputHandler;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

public class RemoveGameHandler implements MenuHandler{

    private final GameService gameService;

    /**
     * Constructs a RemoveGameHandler with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public RemoveGameHandler(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Executes the remove game handler by prompting for title and removing the game.
     *
     * @param collection the game collection to remove the game from
     */
    @Override
    public void execute(GameCollection collection) {

        String title = InputHandler.ask("Title of game to remove");

        if(this.gameService.removeGame(collection, title)){
            MenuView.showMessage("Board game removed successfully.");
        } else {
            MenuView.showMessage("No board game found with that title.");
        }
    }
}
