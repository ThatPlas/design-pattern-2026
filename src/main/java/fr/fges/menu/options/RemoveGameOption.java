package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.RemoveGameHandler;

import java.time.LocalDate;

public class RemoveGameOption implements MenuOption{

    private final GameService gameService;

    /**
     * Constructs a RemoveGameOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public RemoveGameOption(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Returns the title of this menu option.
     *
     * @return the display title "Remove Board Game"
     */
    @Override
    public String title() {
        return "Remove Board Game";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new RemoveGameHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new RemoveGameHandler(this.gameService);
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
