package fr.fges.menu.handlers;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

public class AddGameHandler implements MenuHandler{

    private GameService gameService;

    public AddGameHandler(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public void execute(GameCollection collection) {

        String title = InputHandler.ask("Title");
        int minPlayers = Integer.parseInt(InputHandler.ask("Minimum Players"));
        int maxPlayers = Integer.parseInt(InputHandler.ask("Maximum Players"));
        String category = InputHandler.ask("Category");

        BoardGame game = new BoardGame(title, minPlayers, maxPlayers, category);

        if(!this.gameService.addGame(collection, game)){
            MenuView.showMessage("Error: A game with the title \"" + title + "\" already exists in the collection.");
        } else {
            MenuView.showMessage("Board game added successfully.");
        }
    }
}
