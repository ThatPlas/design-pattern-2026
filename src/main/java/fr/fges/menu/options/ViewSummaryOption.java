package fr.fges.menu.options;

import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.ViewSummaryHandler;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ViewSummaryOption implements MenuOption{


    /**
     * Returns the title of this menu option.
     *
     * @return the display title "View Summary (Weekend Special!)"
     */
    @Override
    public String title() {
        return "View Summary (Weekend Special!)";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new ViewSummaryHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new ViewSummaryHandler();
    }

    /**
     * Checks if this menu option is available on the given date.
     *
     * @param date the date to check availability for
     * @return true only on weekends (Saturday or Sunday)
     */
    @Override
    public boolean isAvailable(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
