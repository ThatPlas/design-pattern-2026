package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.RemoveGameHandler;

import java.time.LocalDate;

public class RemoveGameOption implements MenuOption{

    private final GameService gameService;

    public RemoveGameOption(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public String title() {
        return "Remove Board Game";
    }

    @Override
    public MenuHandler getHandler() {
        return new RemoveGameHandler(this.gameService);
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
