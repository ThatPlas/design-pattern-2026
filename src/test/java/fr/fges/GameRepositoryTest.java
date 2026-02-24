package fr.fges;

public class GameRepositoryTest {

    /*

       A REFAIRE POUR ADAPTER AU NOUVEAU REPO

     */

    /*
    @Test
    public void saveToJSONFile() {
        OldRepository repository = new OldRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertTrue(repository.saveToFile(collection, "saves/test.json"));
    }

    @Test
    public void saveToCSVFile() {
        OldRepository repository = new OldRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertTrue(repository.saveToFile(collection, "saves/test.csv"));
    }

    @Test
    public void saveToUnsupportedFile(){

        OldRepository repository = new OldRepository();
        GameCollection collection = new GameCollection();

        collection.addGame(new BoardGame("Catan", 3, 4, "strategy"));
        assertFalse(repository.saveToFile(collection, "saves/test.txt"));
    }

    @Test
    public void loadFromMissingFile() {
        OldRepository repository = new OldRepository();
        List<BoardGame> games = repository.loadFromFile("nonexistent.json");
        assertEquals(0, games.size());
    }

    @Test
    public void loadFromUnsupportedFile() {
        OldRepository repository = new OldRepository();
        List<BoardGame> games = repository.loadFromFile("unsupported.txt");
        assertEquals(0, games.size());
    }

    @Test
    public void loadFromCSVFile(){
        OldRepository repository = new OldRepository();

        List<BoardGame> games = repository.loadFromFile("saves/test.csv");
        assertEquals(1, games.size());
    }

    @Test
    public void loadFromJSONFile(){
        OldRepository repository = new OldRepository();

        List<BoardGame> games = repository.loadFromFile("saves/test.json");
        assertEquals(1, games.size());
    }*/
}
