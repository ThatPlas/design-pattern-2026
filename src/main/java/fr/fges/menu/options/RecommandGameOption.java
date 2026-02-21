package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.RecommandGameHandler;

import java.time.LocalDate;

public class RecommandGameOption implements MenuOption{

    private final GameService gameService;

    public RecommandGameOption(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public String title() {
        return "Recommand Game";
    }

    @Override
    public MenuHandler getHandler() {
        return new RecommandGameHandler(this.gameService);
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
