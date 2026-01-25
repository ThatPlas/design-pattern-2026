package fr.fges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @BeforeEach
    void setUp() {
        GameCollection.getGames().clear();
    }

    @Test
    void addGame_shouldAddGameToCollection() {
        String input = """
                Catan
                3
                4
                Strategy
                """;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        GameService.addGame();

        assertEquals(1, GameCollection.getGames().size());
        assertEquals("Catan", GameCollection.getGames().get(0).title());
    }

    @Test
    void removeGame_shouldRemoveExistingGame() {
        BoardGame game = new BoardGame("Catan", 3, 4, "Strategy");
        GameCollection.addGame(game);

        System.setIn(new ByteArrayInputStream("Catan\n".getBytes()));

        GameService.removeGame();

        assertEquals(0, GameCollection.getGames().size());
    }
}
