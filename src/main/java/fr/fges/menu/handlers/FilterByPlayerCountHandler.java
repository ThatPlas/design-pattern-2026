package fr.fges.menu.handlers;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

import java.util.List;

public class FilterByPlayerCountHandler implements MenuHandler{

    private final GameService gameService;

    /**
     * Constructs a FilterByPlayerCountHandler with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public FilterByPlayerCountHandler(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Executes the filter handler by prompting for player count and displaying matching games.
     *
     * @param collection the game collection to filter
     */
    @Override
    public void execute(GameCollection collection) {
        int players = Integer.parseInt(InputHandler.ask("How many players?:"));
        List<BoardGame> filteredGames = this.gameService.filterGamesByPlayerCount(collection, players);

        if(filteredGames.isEmpty()){
            MenuView.showMessage("No games found for " + players + " player(s).");
        }

        MenuView.showMessage("\n=== Games for " + players + " player(s) ===");
        for(BoardGame game : filteredGames){
            MenuView.showMessage("- " + game.title() + " (" + game.minPlayers() + "-" + game.maxPlayers() + " players, " + game.category() + ")");
        }

    }
}
