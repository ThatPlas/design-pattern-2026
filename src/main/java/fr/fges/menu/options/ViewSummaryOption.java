package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.ViewSummaryHandler;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ViewSummaryOption implements MenuOption{


    @Override
    public String title() {
        return "View Summary (Weekend Special!)";
    }

    @Override
    public MenuHandler getHandler() {
        return new ViewSummaryHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
