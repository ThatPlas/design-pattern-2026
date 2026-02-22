package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.ExitHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class ExitOption implements MenuOption{

    private final GameService gameService;

    /**
     * Constructs an ExitOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public ExitOption(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Returns the title of this menu option.
     *
     * @return the display title "Exit"
     */
    @Override
    public String title() {
        return "Exit";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new ExitHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new ExitHandler();
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
