package fr.fges.menu.options;

import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.UndoActionHandler;

import java.time.LocalDate;

public class UndoActionOption implements MenuOption{
    @Override
    public String title() {
        return "Undo Last Action";
    }

    @Override
    public MenuHandler getHandler() {
        return new UndoActionHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
