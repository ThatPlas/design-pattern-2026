package fr.fges.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fges.BoardGame;
import fr.fges.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Loads and saves games to CSV or JSON storage.
 */
public class GameRepository {

    /**
     * Loads games from the given storage file.
     *
     * @param storageFile path to the storage file
     * @return list of games or empty list if missing or invalid
     */
    public List<BoardGame> loadFromFile(String storageFile) {
        File file = new File(storageFile);
        if (!file.exists()) {
            return Collections.emptyList();
        }

        if (storageFile.endsWith(".json")) {
            return load(storageFile, new JSONGameRepository());
        } else if (storageFile.endsWith(".csv")) {
            return load(storageFile, new CSVGameRepository());
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Loads games from a file.
     *
     * @param storageFile path to the file
     * @return list of loaded games or empty list on error
     */
    private List<BoardGame> load(String storageFile, Repository<List<BoardGame>> repository) {
        return repository.load(storageFile);
    }

    /**
     * Saves games to the given storage file.
     *
     * @param collection games to save
     * @param storageFile path to the storage file
     */
    public void saveToFile(GameCollection collection, String storageFile) {
        if (storageFile.endsWith(".json")) {
            save(collection, storageFile, new JSONGameRepository());
        } else if (storageFile.endsWith(".csv")) {
            save(collection, storageFile, new CSVGameRepository());
        }
    }

    /**
     * Saves games to a file.
     *
     * @param collection games to save
     * @param storageFile path to the file
     */
    private void save(GameCollection collection, String storageFile, Repository<List<BoardGame>> repository) {
        repository.save(collection.getGames(), storageFile);
    }

}
