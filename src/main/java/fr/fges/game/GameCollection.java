package fr.fges.game;

import fr.fges.BoardGame;
import fr.fges.history.History;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory collection of board games.
 */
public class GameCollection {
    private final List<BoardGame> games;

    private final History history;

    public GameCollection(){
        this.history = new History();
        this.games = new ArrayList<>();
    }

    /**
     * Returns the mutable list of games.
     *
     * @return list of games
     */
    public List<BoardGame> getGames() {
        return games;
    }

    /**
     * Returns the history of changes.
     *
     * @return LogHistory object
     */
    public History getHistory(){
        return this.history;
    }

    /**
     * Adds a game to the collection.
     *
     * @param game game to add
     */
    public void addGame(BoardGame game) {
        games.add(game);
    }

    /**
     * Adds multiple games to the collection.
     *
     * @param games games to add
     */
    public void addGames(List<BoardGame> games) {
        this.games.addAll(games);
    }

    /**
     * Removes a game from the collection.
     *
     * @param game game to remove
     */
    public void removeGame(BoardGame game) {
        games.remove(game);
    }

    public boolean isPresent(String title){
        return games.stream().anyMatch(game -> game.title().equals(title));
    }
}
