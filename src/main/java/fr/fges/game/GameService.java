package fr.fges.game;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.Main;
import fr.fges.history.HistoryService;
import fr.fges.history.actions.AddGameLog;
import fr.fges.history.actions.RemoveGameLog;
import fr.fges.menu.MenuView;

import java.util.List;
import java.util.Optional;

/**
 * Handles user-driven operations on games.
 */
public class GameService {

    private final GameRepository repository;
    private final HistoryService historyService;

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

    public void undoLastAction(GameCollection gameCollection){
        this.historyService.revertLastAction(gameCollection);
    }

    public List<BoardGame> filterGamesByPlayerCount(GameCollection gameCollection, int players){

        java.util.List<BoardGame> filteredGames = gameCollection.getGames().stream()
                .filter(g -> g.minPlayers() <= players && g.maxPlayers() >= players)
                .sorted(java.util.Comparator.comparing(BoardGame::title))
                .toList();

        return filteredGames;
    }
}
