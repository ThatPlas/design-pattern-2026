package fr.fges.menu.options;

import fr.fges.menu.handlers.FilterByPlayerCountHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class FilterByPlayerCountOption implements MenuOption{
    @Override
    public String title() {
        return "Filter Games by player count";
    }

    @Override
    public MenuHandler getHandler() {
        return new FilterByPlayerCountHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
