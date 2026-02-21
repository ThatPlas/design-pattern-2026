package fr.fges.menu.handlers;

import fr.fges.InputHandler;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

public class RemoveGameHandler implements MenuHandler{

    private GameService gameService;

    public RemoveGameHandler(GameService gameService){
        this.gameService = gameService;
    }

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
