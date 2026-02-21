package fr.fges.menu.options;

import fr.fges.game.GameService;
import fr.fges.menu.handlers.AddGameHandler;
import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public class AddGameOption implements MenuOption{

    private final GameService gameService;

    public AddGameOption(GameService gameService){
        this.gameService = gameService;
    }

    @Override
    public String title() {
        return "Add Board Game";
    }

    @Override
    public MenuHandler getHandler() {
        return new AddGameHandler(gameService);
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return true;
    }
}
