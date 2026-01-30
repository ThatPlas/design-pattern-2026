package fr.fges.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fges.BoardGame;
import fr.fges.ExtensionChecker;
import fr.fges.Repository;
import fr.fges.exception.UnsupportedFileExtension;

import javax.xml.validation.Validator;
import java.io.*;
import java.util.*;

/**
 * Loads and saves games to CSV or JSON storage.
 */
public class GameRepository {

    private final Map<String, Repository<List<BoardGame>>> repositories = new HashMap<>();

    public GameRepository(){
        repositories.put(".json", new JSONGameRepository());
        repositories.put(".csv", new CSVGameRepository());
    }

    public void registerRepository(String extension, Repository<List<BoardGame>> repository){
        repositories.put(extension.toLowerCase(), repository);
    }

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

        try {
            ExtensionChecker.checkFileExtension(storageFile, this);
        } catch (UnsupportedFileExtension e) {
            return Collections.emptyList();
        }

        Repository<List<BoardGame>> repository = repositories.get(storageFile.toLowerCase().substring(storageFile.lastIndexOf('.')));

        return repository.load(storageFile);
    }

    /**
     * Saves games to the given storage file.
     *
     * @param collection games to save
     * @param storageFile path to the storage file
     * @return true if save operation was successful, false otherwise
     */
    public boolean saveToFile(GameCollection collection, String storageFile) {

        try {
            ExtensionChecker.checkFileExtension(storageFile, this);
        } catch (UnsupportedFileExtension e) {
            return false;
        }

        File file = new File(storageFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }

        if(collection == null){
            return false;
        }

        Repository<List<BoardGame>> repository = repositories.get(storageFile.toLowerCase().substring(storageFile.lastIndexOf('.')));

        return repository.save(collection.getGames(), storageFile);
    }

    /**
     * Checks if the given file extension is supported by any repository.
     *
     * @param extension file extension to check
     * @return true if supported, false otherwise
     */

    public boolean isSupportedExtension(String extension) {
        return repositories.containsKey(extension.toLowerCase());
    }

}
