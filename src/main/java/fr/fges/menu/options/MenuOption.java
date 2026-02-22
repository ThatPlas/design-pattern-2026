package fr.fges.menu.options;

import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public interface MenuOption {

    /**
     * Returns the display title of this menu option.
     *
     * @return the title string
     */
    String title();
    /**
     * Returns the handler that executes this menu option's action.
     *
     * @return the menu handler
     */
    MenuHandler getHandler();
    /**
     * Checks if this menu option is available on the given date.
     *
     * @param date the date to check availability for
     * @return true if available, false otherwise
     */
    boolean isAvailable(LocalDate date);

}
