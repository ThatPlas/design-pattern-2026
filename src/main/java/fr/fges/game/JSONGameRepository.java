package fr.fges.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fges.BoardGame;
import fr.fges.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JSONGameRepository implements Repository {
    @Override
    public boolean save(List<BoardGame> object, String file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(file), object);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving to JSON: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<BoardGame> load(String storageFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(storageFile);
            List<BoardGame> loadedGames = mapper.readValue(file, new TypeReference<>() {
            });

            return loadedGames;
        } catch (IOException e) {
            System.out.println("Error loading from JSON: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
