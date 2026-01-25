package fr.fges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void addGame_shouldAddGameToCollection() {

        GameCollection collection = new GameCollection();

        String input = """
                Catan
                3
                4
                Strategy
                """;

        InputHandler.setInput(new ByteArrayInputStream(input.getBytes()));

        GameService.addGame(collection);

        assertEquals(1, collection.getGames().size());
        assertEquals("Catan", collection.getGames().getFirst().title());
    }

    @Test
    void removeGame_shouldRemoveExistingGame() {

        GameCollection collection = new GameCollection();
        BoardGame game = new BoardGame("Catan", 3, 4, "Strategy");
        collection.addGame(game);

        InputHandler.setInput(new ByteArrayInputStream("Catan\n".getBytes()));

        GameService.removeGame(collection);

        assertEquals(0, collection.getGames().size());
    }
}
