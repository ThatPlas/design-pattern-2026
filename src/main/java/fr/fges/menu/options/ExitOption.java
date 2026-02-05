package fr.fges.menu.options;

import fr.fges.menu.handlers.ExitHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class ExitOption implements MenuOption{
    @Override
    public String title() {
        return "Exit";
    }

    @Override
    public MenuHandler getHandler() {
        return new ExitHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
