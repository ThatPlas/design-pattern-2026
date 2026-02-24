package fr.fges.game;

import fr.fges.BoardGame;
import fr.fges.GameRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVGameRepository implements GameRepository {

    private String storageFile;

    public CSVGameRepository(String storageFile){
        this.storageFile = storageFile;
    }

    /**
     * Saves a list of board games to a CSV file.
     *
     * @param games the list of games to save
     * @return true if save was successful, false otherwise
     */
    @Override
    public boolean save(List<BoardGame> games) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.storageFile))) {
            writer.write("title,minPlayers,maxPlayers,category");
            writer.newLine();
            for (BoardGame game : games) {
                writer.write(game.title() + "," + game.minPlayers() + "," + game.maxPlayers() + "," + game.category());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error saving to CSV: " + e.getMessage());
            return false;
        }
    }

    /**
     * Loads board games from a CSV file.
     *
     * @return list of loaded games, or empty list if error occurs
     */
    @Override
    public List<BoardGame> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.storageFile))) {
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
}
