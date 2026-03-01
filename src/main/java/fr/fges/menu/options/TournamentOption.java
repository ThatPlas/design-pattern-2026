package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.TournamentHandler;
import fr.fges.tournament.TournamentService;

import java.time.LocalDate;

public class TournamentOption implements MenuOption{
    private final GameService gameService;
    private final TournamentService tournamentService;

    /**
     * Constructs a TournamentOption with the specified game service.
     *
     * @param gameService the service for handling game operations
     */
    public TournamentOption(GameService gameService, TournamentService tournamentService){
        this.gameService = gameService;
        this.tournamentService = tournamentService;
    }

    @Override
    public String title() {
        return "Tournament Mode";
    }

    @Override
    public MenuHandler getHandler() {
        return new TournamentHandler(this.gameService, this.tournamentService);
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
