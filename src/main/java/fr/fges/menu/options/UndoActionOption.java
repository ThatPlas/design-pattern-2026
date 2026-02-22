package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.UndoActionHandler;

import java.time.LocalDate;

public class UndoActionOption implements MenuOption{

    private final GameService gameService;

    /**
     * Constructs an UndoActionOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public UndoActionOption(GameService gameService){
        this.gameService = gameService;
    }

    /**
     * Returns the title of this menu option.
     *
     * @return the display title "Undo Last Action"
     */
    @Override
    public String title() {
        return "Undo Last Action";
    }

    /**
     * Returns the handler for this menu option.
     *
     * @return a new UndoActionHandler instance
     */
    @Override
    public MenuHandler getHandler() {
        return new UndoActionHandler(this.gameService);
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
