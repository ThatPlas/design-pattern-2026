package fr.fges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    void filterGames_shouldBeEmpty() {
        GameCollection collection = new GameCollection();
        BoardGame game = new BoardGame("Catan", 3, 4, "Strategy");
        collection.addGame(game);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        InputHandler.setInput(new ByteArrayInputStream("2\n".getBytes()));
        try {
            GameService.filterGamesByPlayerCount(collection);
        } finally {
            System.setOut(original);
        }
        String output = out.toString();

        assertTrue(output.contains("No games found for 2 player(s)."));
    }

    @Test
    void filterGames_shouldReturnOne() {
        GameCollection collection = new GameCollection();
        BoardGame game = new BoardGame("Dead Cells", 2, 4, "Strategy");
        collection.addGame(game);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        InputHandler.setInput(new ByteArrayInputStream("2\n".getBytes()));
        try {
            GameService.filterGamesByPlayerCount(collection);
        } finally {
            System.setOut(original);
        }
        String output = out.toString();

        assertTrue(output.contains("=== Games for 2 player(s) ==="));
    }
}
