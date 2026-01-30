package fr.fges;

import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameRepositoryTest {

    @Test
    public void saveToJSONFile() {
        GameRepository repository = new GameRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertTrue(repository.saveToFile(collection, "saves/test.json"));
    }

    @Test
    public void saveToCSVFile() {
        GameRepository repository = new GameRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertTrue(repository.saveToFile(collection, "saves/test.csv"));
    }

    @Test
    public void saveToUnsupportedFile(){

        GameRepository repository = new GameRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertFalse(repository.saveToFile(collection, "saves/test.txt"));
    }

    @Test
    public void loadFromMissingFile() {
        GameRepository repository = new GameRepository();
        List<BoardGame> games = repository.loadFromFile("nonexistent.json");
        assertEquals(0, games.size());
    }

    @Test
    public void loadFromUnsupportedFile() {
        GameRepository repository = new GameRepository();
        List<BoardGame> games = repository.loadFromFile("unsupported.txt");
        assertEquals(0, games.size());
    }

    @Test
    public void loadFromCSVFile(){
        GameRepository repository = new GameRepository();

        List<BoardGame> games = repository.loadFromFile("saves/test.csv");
        assertEquals(1, games.size());
    }

    @Test
    public void loadFromJSONFile(){
        GameRepository repository = new GameRepository();

        List<BoardGame> games = repository.loadFromFile("saves/test.json");
        assertEquals(1, games.size());
    }
}
