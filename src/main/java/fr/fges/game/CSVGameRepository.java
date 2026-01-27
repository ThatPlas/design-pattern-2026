package fr.fges.game;

import fr.fges.BoardGame;
import fr.fges.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVGameRepository implements Repository<List<BoardGame>> {

    @Override
    public boolean save(List<BoardGame> games, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
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

    @Override
    public List<BoardGame> load(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
