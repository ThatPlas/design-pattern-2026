package fr.fges.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fges.BoardGame;
import fr.fges.GameRepository;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JSONGameRepository implements GameRepository {

    private String storageFile;

    public JSONGameRepository(String storageFile){
        this.storageFile = storageFile;
    }

    /**
     * Saves a list of board games to a JSON file with pretty printing.
     *
     * @param object the list of games to save
     * @return true if save was successful, false otherwise
     */
    @Override
    public boolean save(List<BoardGame> object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(this.storageFile), object);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving to JSON: " + e.getMessage());
            return false;
        }
    }

    /**
     * Loads board games from a JSON file.
     *
     * @return list of loaded games, or empty list if error occurs
     */
    @Override
    public List<BoardGame> load() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(this.storageFile);

            return mapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println("Error loading from JSON: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
