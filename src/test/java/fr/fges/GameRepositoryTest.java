package fr.fges;

import fr.fges.game.GameRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameRepositoryTest {

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
}
