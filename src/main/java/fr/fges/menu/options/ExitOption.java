package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.ExitHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class ExitOption implements MenuOption{

    private final GameService gameService;

    public ExitOption(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public String title() {
        return "Exit";
    }

    @Override
    public MenuHandler getHandler() {
        return new ExitHandler();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
