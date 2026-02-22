package fr.fges.game;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.Main;
import fr.fges.history.HistoryService;
import fr.fges.history.actions.AddGameLog;
import fr.fges.history.actions.RemoveGameLog;

import java.util.List;
import java.util.Optional;

/**
 * Handles user-driven operations on games.
 */
public class GameService {

    private final GameRepository repository;
    private final HistoryService historyService;

    /**
     * Constructs a GameService with the specified repository and history service.
     *
     * @param gameRepository the repository for persisting game data
     * @param historyService the service for managing game history
     */
    public GameService(GameRepository gameRepository, HistoryService historyService){
        this.repository = gameRepository;
        this.historyService = historyService;
    }

    /**
     * Prompts for game details and adds the game to the collection.
     *
     * @param gameCollection collection to modify
     */
    public boolean addGame(GameCollection gameCollection, BoardGame game) {

        if(gameCollection.isPresent(game.title())){
            return false;
        }

        gameCollection.addGame(game);
        this.historyService.addLogAction(gameCollection.getHistory(), new AddGameLog(gameCollection, game));
        this.repository.saveToFile(gameCollection, Main.getStorageFile());
        return true;
    }

    /**
     * Recommends a game based on the specified number of players.
     *
     * @param gameCollection the collection to search for games
     * @return an Optional containing a suitable game, or empty if none found
     */
    public Optional<BoardGame> recommendGame(GameCollection gameCollection){
        int players = Integer.parseInt(InputHandler.ask("How many players?:"));

        BoardGame game = gameCollection.getGames().stream()
                .filter(g -> g.minPlayers() <= players && g.maxPlayers() >= players)
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(game);
    }

    /**
     * Prompts for a title and removes the first matching game.
     *
     * @param gameCollection collection to modify
     */
    public boolean removeGame(GameCollection gameCollection, String title) {

        for (BoardGame game : gameCollection.getGames()) {
            if (game.title().equals(title)) {
                gameCollection.removeGame(game);
                this.historyService.addLogAction(gameCollection.getHistory(), new RemoveGameLog(gameCollection, game));
                this.repository.saveToFile(gameCollection, Main.getStorageFile());
                return true;
            }
        }
        return false;
    }

    /**
     * Undoes the last action performed on the game collection.
     *
     * @param gameCollection the collection to revert the last action on
     */
    public void undoLastAction(GameCollection gameCollection){
        this.historyService.revertLastAction(gameCollection);
    }

    /**
     * Filters games in the collection by the specified number of players.
     *
     * @param gameCollection the collection to filter
     * @param players the number of players to filter by
     * @return a list of games that support the specified number of players, sorted by title
     */
    public List<BoardGame> filterGamesByPlayerCount(GameCollection gameCollection, int players){

        return gameCollection.getGames().stream()
                .filter(g -> g.minPlayers() <= players && g.maxPlayers() >= players)
                .sorted(java.util.Comparator.comparing(BoardGame::title))
                .toList();
    }
}
