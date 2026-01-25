package fr.fges.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fges.BoardGame;

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
            return loadFromJson(storageFile);
        } else if (storageFile.endsWith(".csv")) {
            return loadFromCsv(storageFile);
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Loads games from a JSON file.
     *
     * @param storageFile path to the JSON file
     * @return list of loaded games or empty list on error
     */
    private List<BoardGame> loadFromJson(String storageFile) {
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

    /**
     * Loads games from a CSV file.
     *
     * @param storageFile path to the CSV file
     * @return list of loaded games or empty list on error
     */
    private List<BoardGame> loadFromCsv(String storageFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(storageFile))) {
            String line;
            boolean firstLine = true;
            List<BoardGame> loadedGames = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // skip header
                }
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    BoardGame game = new BoardGame(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            parts[3]
                    );
                    loadedGames.add(game);
                }
            }
            return loadedGames;
        } catch (IOException e) {
            System.out.println("Error loading from CSV: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Saves games to the given storage file.
     *
     * @param collection games to save
     * @param storageFile path to the storage file
     */
    public void saveToFile(GameCollection collection, String storageFile) {
        if (storageFile.endsWith(".json")) {
            saveToJson(collection, storageFile);
        } else if (storageFile.endsWith(".csv")) {
            saveToCsv(collection, storageFile);
        }
    }

    /**
     * Saves games to a JSON file.
     *
     * @param collection games to save
     * @param storageFile path to the JSON file
     */
    private void saveToJson(GameCollection collection, String storageFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(storageFile), collection.getGames());
        } catch (IOException e) {
            System.out.println("Error saving to JSON: " + e.getMessage());
        }
    }

    /**
     * Saves games to a CSV file.
     *
     * @param collection games to save
     * @param storageFile path to the CSV file
     */
    private void saveToCsv(GameCollection collection, String storageFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storageFile))) {
            writer.write("title,minPlayers,maxPlayers,category");
            writer.newLine();
            for (BoardGame game : collection.getGames()) {
                writer.write(game.title() + "," + game.minPlayers() + "," + game.maxPlayers() + "," + game.category());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to CSV: " + e.getMessage());
        }
    }

}
