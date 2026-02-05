package fr.fges.menu.options;

import fr.fges.menu.handlers.AddGameHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class AddGameOption implements MenuOption{
    @Override
    public String title() {
        return "Add Board Game";
    }

    @Override
    public MenuHandler getHandler() {
        return new AddGameHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
