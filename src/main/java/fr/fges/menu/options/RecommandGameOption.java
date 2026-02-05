package fr.fges.menu.options;

import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.RecommandGameHandler;

import java.time.LocalDate;

public class RecommandGameOption implements MenuOption{
    @Override
    public String title() {
        return "Recommand Game";
    }

    @Override
    public MenuHandler getHandler() {
        return new RecommandGameHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
