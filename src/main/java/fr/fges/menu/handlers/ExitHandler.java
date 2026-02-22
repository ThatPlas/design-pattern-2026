package fr.fges.menu.handlers;

import fr.fges.Main;
import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;
import fr.fges.menu.MenuView;

public class ExitHandler implements MenuHandler{
    /**
     * Executes the exit handler by saving the collection and exiting the application.
     *
     * @param collection the game collection to save before exiting
     */
    @Override
    public void execute(GameCollection collection) {
        MenuView.showMessage("Exiting the application. Goodbye!");
        GameRepository repository = new GameRepository();
        repository.saveToFile(collection, Main.getStorageFile());
        System.exit(0);
    }
}
