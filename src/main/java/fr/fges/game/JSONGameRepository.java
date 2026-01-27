package fr.fges.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fges.BoardGame;
import fr.fges.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JSONGameRepository implements Repository<List<BoardGame>> {
    @Override
    public void save(List<BoardGame> object, String file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(file), object);
        } catch (IOException e) {
            System.out.println("Error saving to JSON: " + e.getMessage());
        }
    }

    @Override
    public List<BoardGame> load(String storageFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(storageFile);
            List<BoardGame> loadedGames = mapper.readValue(file, new TypeReference<List<BoardGame>>() {});

            return loadedGames;
        } catch (IOException e) {
            System.out.println("Error loading from JSON: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
