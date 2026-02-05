package fr.fges.menu.options;

import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class RemoveGameOption implements MenuOption{
    @Override
    public String title() {
        return "Remove Board Game";
    }

    @Override
    public MenuHandler getHandler() {
        return null;
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
