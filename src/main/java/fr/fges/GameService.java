package fr.fges;

public class GameService {

    public static void addGame() {
        String title = InputHandler.ask("Title");
        int minPlayers = Integer.parseInt(InputHandler.ask("Minimum Players"));
        int maxPlayers = Integer.parseInt(InputHandler.ask("Maximum Players"));
        String category = InputHandler.ask("Category");

        BoardGame game = new BoardGame(title, minPlayers, maxPlayers, category);
        GameCollection.addGame(game);

        MenuView.showMessage("Board game added successfully.");
    }

    public static void removeGame() {
        String title = InputHandler.ask("Title of game to remove");

        for (BoardGame game : GameCollection.getGames()) {
            if (game.title().equals(title)) {
                GameCollection.removeGame(game);
                MenuView.showMessage("Board game removed successfully.");
                return;
            }
        }
        MenuView.showMessage("No board game found with that title.");
    }

    public static void listGames() {
        GameCollection.viewAllGames();
    }
}
