package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.FilterByPlayerCountHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class FilterByPlayerCountOption implements MenuOption{

    private final GameService gameService;

    /**
     * Constructs a FilterByPlayerCountOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public FilterByPlayerCountOption(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Returns the title of this menu option.
     *
     * @return the display title "Filter Games by player count"
     */
    @Override
    public String title() {
        return "Filter Games by player count";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new FilterByPlayerCountHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new FilterByPlayerCountHandler(this.gameService);
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
