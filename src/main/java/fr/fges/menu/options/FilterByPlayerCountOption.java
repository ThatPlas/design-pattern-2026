package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.FilterByPlayerCountHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class FilterByPlayerCountOption implements MenuOption{

    private final GameService gameService;

    public FilterByPlayerCountOption(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public String title() {
        return "Filter Games by player count";
    }

    @Override
    public MenuHandler getHandler() {
        return new FilterByPlayerCountHandler(this.gameService);
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
