package fr.fges.menu.options;

import fr.fges.menu.handlers.ListGameHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class ListGameOption implements MenuOption{
    /**
     * Returns the title of this menu option.
     *
     * @return the display title "List All Board Games"
     */
    @Override
    public String title() {
        return "List All Board Games";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new ListGameHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new ListGameHandler();
    }

    /**
     * Checks if this menu option is available on the given date.
     *
     * @param date the date to check availability for
     * @return always true (this option is always available)
     */
    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
