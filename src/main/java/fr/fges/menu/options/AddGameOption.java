package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.AddGameHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class AddGameOption implements MenuOption{

    private final GameService gameService;

    /**
     * Constructs an AddGameOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public AddGameOption(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Returns the title of this menu option.
     *
     * @return the display title "Add Board Game"
     */
    @Override
    public String title() {
        return "Add Board Game";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new AddGameHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new AddGameHandler(gameService);
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
