package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;
import fr.fges.menu.MenuView;

public class ExitHandler implements MenuHandler{
    @Override
    public void execute(GameCollection collection) {
        MenuView.showMessage("Exiting the application. Goodbye!");
        System.exit(0);
    }
}
