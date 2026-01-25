package fr.fges.game;

import fr.fges.BoardGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameCollection {
    private final List<BoardGame> games = new ArrayList<>();

    public List<BoardGame> getGames() {
        return games;
    }

    public void addGame(BoardGame game) {
        games.add(game);
    }

    public void addGames(List<BoardGame> games) {
        this.games.addAll(games);
    }

    public void removeGame(BoardGame game) {
        games.remove(game);
    }
}
