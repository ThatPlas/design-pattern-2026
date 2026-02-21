package fr.fges.menu.handlers;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

import java.util.Optional;

public class RecommandGameHandler implements MenuHandler{

    private GameService gameService;

    public RecommandGameHandler(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public void execute(GameCollection collection) {
        Optional<BoardGame> optional = this.gameService.recommendGame(collection);
        if(optional.isEmpty()){
            MenuView.showMessage("No game found.");
        } else {
            BoardGame game = optional.get();

            MenuView.showMessage("Recommended game: \"" + game + "\" (" + game.minPlayers() + "-" + game.maxPlayers() + " players, " + game.category() + ")");
        }
    }
}
