package fr.fges.menu.options;

import fr.fges.menu.handlers.ListGameHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class ListGameOption implements MenuOption{
    @Override
    public String title() {
        return "List All Board Games";
    }

    @Override
    public MenuHandler getHandler() {
        return new ListGameHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
