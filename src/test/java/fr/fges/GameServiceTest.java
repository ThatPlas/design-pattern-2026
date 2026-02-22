package fr.fges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;
import fr.fges.game.GameService;
import fr.fges.history.HistoryService;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class GameServiceTest {

    /**
     * Tests that a game can be successfully added to a collection.
     * Verifies that the game is added and the collection size increases.
     */
    @Test
    void addGame_shouldAddGameToCollection() {

        try (MockedStatic<Main> mockedMain = mockStatic(Main.class)) {
            mockedMain.when(Main::getStorageFile).thenReturn("saves/test.json");

            when(Main.getStorageFile()).thenReturn("saves/test.json");

            GameCollection collection = new GameCollection();

            GameService gameService = new GameService(new GameRepository(), new HistoryService());

            gameService.addGame(collection, new BoardGame("Catan", 3, 4, "Strategy"));

            assertEquals(1, collection.getGames().size());
            assertEquals("Catan", collection.getGames().getFirst().title());
        }
    }

    /**
     * Tests that an existing game can be successfully removed from a collection.
     * Verifies that the game is removed and the collection size decreases to zero.
     */
    @Test
    void removeGame_shouldRemoveExistingGame() {

        try (MockedStatic<Main> mockedMain = mockStatic(Main.class)){
            mockedMain.when(Main::getStorageFile).thenReturn("saves/test.json");

            GameCollection collection = new GameCollection();
            GameService gameService = new GameService(new GameRepository(), new HistoryService());
            BoardGame game = new BoardGame("Catan", 3, 4, "Strategy");
            collection.addGame(game);

            gameService.removeGame(collection, game.title());

            assertEquals(0, collection.getGames().size());
        }
    }

    /*

    À retirer, c'est de l'UI

    @Test
    void filterGames_shouldBeEmpty() {
        GameCollection collection = new GameCollection();

        GameService gameService = new GameService(new GameRepository(), new HistoryService());

        BoardGame game = new BoardGame("Catan", 3, 4, "Strategy");
        collection.addGame(game);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            gameService.filterGamesByPlayerCount(collection, 2);
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
    }*/
}
