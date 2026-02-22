package fr.fges.menu.handlers;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

import java.util.Optional;

public class RecommandGameHandler implements MenuHandler{

    private final GameService gameService;

    /**
     * Constructs a RecommandGameHandler with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public RecommandGameHandler(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Executes the recommend game handler by finding and displaying a suitable game.
     *
     * @param collection the game collection to search for recommendations
     */
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
