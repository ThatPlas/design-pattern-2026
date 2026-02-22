package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.RecommandGameHandler;

import java.time.LocalDate;

public class RecommandGameOption implements MenuOption{

    private final GameService gameService;

    /**
     * Constructs a RecommandGameOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public RecommandGameOption(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Returns the title of this menu option.
     *
     * @return the display title "Recommand Game"
     */
    @Override
    public String title() {
        return "Recommand Game";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new RecommandGameHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new RecommandGameHandler(this.gameService);
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
