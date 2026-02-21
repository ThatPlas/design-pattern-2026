package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.handlers.UndoActionHandler;

import java.time.LocalDate;

public class UndoActionOption implements MenuOption{

    private final GameService gameService;

    public UndoActionOption(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public String title() {
        return "Undo Last Action";
    }

    @Override
    public MenuHandler getHandler() {
        return new UndoActionHandler(this.gameService);
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
