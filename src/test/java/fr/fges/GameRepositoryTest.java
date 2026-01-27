package fr.fges;

import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRepositoryTest {

    @Test
    public void saveToJSONFile() {
        GameRepository repository = new GameRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertTrue(repository.saveToFile(collection, "test.json"));
    }

    @Test
    public void saveToCSVFile() {
        GameRepository repository = new GameRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertTrue(repository.saveToFile(collection, "test.csv"));
    }

    @Test
    public void testLoadFromMissingFile() {
        GameRepository repository = new GameRepository();
        List<BoardGame> games = repository.loadFromFile("nonexistent.json");
        assertEquals(0, games.size());
    }

    @Test
    public void testLoadFromUnsupportedFile() {
        GameRepository repository = new GameRepository();
        List<BoardGame> games = repository.loadFromFile("nonexistent.txt");
        assertEquals(0, games.size());
    }

    @Test
    public void loadFromCSVFile(){
        GameRepository repository = new GameRepository();

        List<BoardGame> games = repository.loadFromFile("test.csv");
        assertEquals(1, games.size());
    }

    @Test
    public void loadFromJSONFile(){
        GameRepository repository = new GameRepository();

        List<BoardGame> games = repository.loadFromFile("test.json");
        assertEquals(1, games.size());
    }
}
