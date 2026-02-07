package fr.fges.game;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.history.HistoryService;
import fr.fges.history.actions.AddGameLog;
import fr.fges.history.actions.RemoveGameLog;
import fr.fges.menu.MenuView;

/**
 * Handles user-driven operations on games.
 */
public class GameService {

    /**
     * Prompts for game details and adds the game to the collection.
     *
     * @param gameCollection collection to modify
     */
    public static void addGame(GameCollection gameCollection) {
        String title = InputHandler.ask("Title");
        int minPlayers = Integer.parseInt(InputHandler.ask("Minimum Players"));
        int maxPlayers = Integer.parseInt(InputHandler.ask("Maximum Players"));
        String category = InputHandler.ask("Category");

        BoardGame game = new BoardGame(title, minPlayers, maxPlayers, category);

        if(gameCollection.isPresent(title)){
            MenuView.showMessage("Error: A game with the title \"" + title + "\" already exists in the collection.");
            return;
        }

        gameCollection.addGame(game);
        MenuView.showMessage("Board game added successfully.");
        HistoryService.addLogAction(gameCollection.getHistory(), new AddGameLog(gameCollection, game));
    }

    public static void recommendGame(GameCollection gameCollection){
        int players = Integer.parseInt(InputHandler.ask("How many players?:"));

        BoardGame game = gameCollection.getGames().stream()
                .filter(g -> g.minPlayers() <= players && g.maxPlayers() >= players)
                .findFirst()
                .orElse(null);

        if(game == null){
            MenuView.showMessage("No game found.");
            return;
        }

        MenuView.showMessage("Recommended game: \"" + game + "\" (" + game.minPlayers() + "-" + game.maxPlayers() + " players, " + game.category() + ")");
    }

    /**
     * Prompts for a title and removes the first matching game.
     *
     * @param gameCollection collection to modify
     */
    public static void removeGame(GameCollection gameCollection) {
        String title = InputHandler.ask("Title of game to remove");

        for (BoardGame game : gameCollection.getGames()) {
            if (game.title().equals(title)) {
                gameCollection.removeGame(game);
                HistoryService.addLogAction(gameCollection.getHistory(), new RemoveGameLog(gameCollection, game));
                MenuView.showMessage("Board game removed successfully.");
                return;
            }
        }
        MenuView.showMessage("No board game found with that title.");
    }

    public static void undoLastAction(GameCollection gameCollection){
        HistoryService.revertLastAction(gameCollection);
        MenuView.showMessage("Last action reverted successfully.");
    }

    /**
     * Displays all games in the collection.
     *
     * @param gameCollection collection to display
     */
    public static void listGames(GameCollection gameCollection) {
        GamePrinter gamePrinter = new GamePrinter(gameCollection);
        gamePrinter.viewAllGames();
    }

    public static void summaryGames(GameCollection gameCollection){
        GamePrinter gamePrinter = new GamePrinter(gameCollection);
        gamePrinter.summaryGames();
    }

    public static void filterGamesByPlayerCount(GameCollection gameCollection){
        int players = Integer.parseInt(InputHandler.ask("How many players?:"));

        java.util.List<BoardGame> filteredGames = gameCollection.getGames().stream()
                .filter(g -> g.minPlayers() <= players && g.maxPlayers() >= players)
                .sorted(java.util.Comparator.comparing(BoardGame::title))
                .toList();

        if(filteredGames.isEmpty()){
            MenuView.showMessage("No games found for " + players + " player(s).");
            return;
        }

        MenuView.showMessage("\n=== Games for " + players + " player(s) ===");
        for(BoardGame game : filteredGames){
            MenuView.showMessage("- " + game.title() + " (" + game.minPlayers() + "-" + game.maxPlayers() + " players, " + game.category() + ")");
        }
    }
}
