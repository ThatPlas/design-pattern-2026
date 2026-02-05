package fr.fges.game;

import fr.fges.BoardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Prints games from a collection to the console.
 */
public class GamePrinter {

    private GameCollection gameCollection;

    /**
     * Creates a printer for the given collection.
     *
     * @param gameCollection collection to render
     */
    public GamePrinter(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    /**
     * Displays all games in alphabetical order.
     */
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

    public void summaryGames(){

        System.out.println();

        if(this.gameCollection.getGames().isEmpty()){
            System.out.println("Game collection is empty.");
            return;
        }

        System.out.println("=== Summary (3 random games) ===");

        List<BoardGame> games = new ArrayList<>(this.gameCollection.getGames());
        Collections.shuffle(games);

        for(int i = 0; i < Math.min(games.size(), 2); i++){

            BoardGame game = games.get(i);

            System.out.println("- " + game.title() + " (" + game.minPlayers() + "-" + game.maxPlayers() + ", " + game.category() + ")");
        }

    }

}
