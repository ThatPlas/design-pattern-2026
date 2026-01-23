package fr.fges.game;

import fr.fges.BoardGame;

import java.util.Comparator;
import java.util.List;

public class GamePrinter {

    private GameCollection gameCollection;

    public GamePrinter(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    public void viewAllGames() {
        if (this.gameCollection.getGames().isEmpty()) {
            System.out.println("No board games in collection.");
            return;
        }

        // Sort the games by their title alphabetically
        List<BoardGame> sortedGames = this.gameCollection.getGames().stream()
                .sorted(Comparator.comparing(BoardGame::title))
                .toList();

        for (BoardGame game : sortedGames) {
            System.out.println("Game: " + game.title() + " (" + game.minPlayers() + "-" + game.maxPlayers() + " players) - " + game.category());
        }
    }

}
