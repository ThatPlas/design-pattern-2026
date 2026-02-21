package fr.fges;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.awt.*;
import java.io.ByteArrayInputStream;

import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;
import fr.fges.game.GameService;
import fr.fges.history.HistoryService;
import fr.fges.menu.MenuController;
import org.junit.jupiter.api.Test;

class MenuControllerTest {

    @Test
    void handleMenu_withInvalidChoice_shouldNotCrash() {
        System.setIn(new ByteArrayInputStream("invalid\n".getBytes()));
        GameService gameService = new GameService(new GameRepository(), new HistoryService());
        MenuController menuController = new MenuController(gameService);

        assertDoesNotThrow(() -> menuController.handleMenu(new GameCollection()));
    }
}
