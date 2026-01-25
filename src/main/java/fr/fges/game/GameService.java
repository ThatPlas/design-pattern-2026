package fr.fges.game;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.MenuView;

public class GameService {

    public static void addGame(GameCollection gameCollection) {
        String title = InputHandler.ask("Title");
        int minPlayers = Integer.parseInt(InputHandler.ask("Minimum Players"));
        int maxPlayers = Integer.parseInt(InputHandler.ask("Maximum Players"));
        String category = InputHandler.ask("Category");

        BoardGame game = new BoardGame(title, minPlayers, maxPlayers, category);
        gameCollection.addGame(game);

        MenuView.showMessage("Board game added successfully.");
    }

    public static void removeGame(GameCollection gameCollection) {
        String title = InputHandler.ask("Title of game to remove");

        for (BoardGame game : gameCollection.getGames()) {
            if (game.title().equals(title)) {
                gameCollection.removeGame(game);
                MenuView.showMessage("Board game removed successfully.");
                return;
            }
        }
        MenuView.showMessage("No board game found with that title.");
    }

    public static void listGames(GameCollection gameCollection) {

        GamePrinter gamePrinter = new GamePrinter(gameCollection);

        gamePrinter.viewAllGames();
    }
}
