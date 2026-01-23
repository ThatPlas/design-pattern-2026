package fr.fges;

import fr.fges.game.GameCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameCollectionTest {

    @Test
    public void testAddGame() {
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertEquals(1, collection.getGames().size());
    }

    @Test
    public void testRemoveGame(){
        GameCollection collection = new GameCollection();
        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        collection.removeGame(collection.getGames().getFirst());
        assertEquals(0, collection.getGames().size());
    }

}
