package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.TournamentHandler;

import java.time.LocalDate;

public class TournamentOption implements MenuOption{
    private final GameService gameService;

    /**
     * Constructs a TournamentOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public TournamentOption(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public String title() {
        return "Tournament Mode";
    }

    @Override
    public MenuHandler getHandler() {
        return new TournamentHandler(this.gameService);
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
