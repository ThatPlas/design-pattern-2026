package fr.fges;

import fr.fges.exception.UnsupportedFileExtension;
import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;
import fr.fges.game.GameService;
import fr.fges.history.HistoryService;
import fr.fges.menu.MenuController;

/**
 * Application entry point for the board game collection CLI.
 */
public class Main {

    private static String storageFile;

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

        GameRepository repository = new GameRepository();
        HistoryService historyService = new HistoryService();
        GameService gameService = new GameService(repository, historyService);

        MenuController menuController = new MenuController(gameService);

        Main.storageFile = args[0];

        String storageFile = args[0];
        ExtensionChecker.checkFileExtension(storageFile, repository);

        GameCollection collection = new GameCollection();

        collection.addGames(
                repository.loadFromFile(storageFile)
        );

        System.out.println("Using storage file: " + storageFile);

        while (true) {
            menuController.handleMenu(collection);
        }

    }

    public static String getStorageFile(){
        return Main.storageFile;
    }
}


