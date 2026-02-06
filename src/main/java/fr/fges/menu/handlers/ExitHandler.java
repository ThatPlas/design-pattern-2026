package fr.fges.menu.handlers;

import fr.fges.Main;
import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;
import fr.fges.menu.MenuView;

public class ExitHandler implements MenuHandler{
    @Override
    public void execute(GameCollection collection) {
        MenuView.showMessage("Exiting the application. Goodbye!");
        GameRepository repository = new GameRepository();
        repository.saveToFile(collection, Main.getStorageFile());
        System.exit(0);
    }
}
