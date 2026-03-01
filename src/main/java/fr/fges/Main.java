package fr.fges;

import fr.fges.exception.UnsupportedFileExtension;
import fr.fges.game.GameCollection;
import fr.fges.game.GameRepositoryFactory;
import fr.fges.game.GameService;
import fr.fges.history.HistoryService;
import fr.fges.menu.MenuController;
import fr.fges.tournament.TournamentService;

/**
 * Application entry point for the board game collection CLI.
 */
public class Main {

    /**
     * Boots the application and starts the menu loop.
     *
     * @param args command-line arguments with storage file path
     */
    public static void main(String[] args) throws UnsupportedFileExtension {

        if (args.length < 1) {
            System.out.println("Usage: java -jar boardgamecollection.jar <storage-file>");
            System.out.println("Storage file must be a supported format.");
            System.exit(1);
        }

        GameRepository repository = GameRepositoryFactory.create(args[0]);
        HistoryService historyService = new HistoryService();
        GameService gameService = new GameService(repository, historyService);
        TournamentService tournamentService = new TournamentService();

        MenuController menuController = new MenuController(gameService, tournamentService);

        GameCollection collection = new GameCollection();

        collection.addGames(repository.load());

        System.out.println("Using storage file: " + args[0]);

        while (true) {
            menuController.handleMenu(collection);
        }

    }
}


