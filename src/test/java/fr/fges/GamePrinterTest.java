package fr.fges;

import fr.fges.game.GameCollection;
import fr.fges.game.GamePrinter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GamePrinterTest {

    @Test
    void testViewAllGames() {
        GameCollection collection = new GameCollection();
        GamePrinter printer = new GamePrinter(collection);
        collection.addGame(new BoardGame("Catan", 3, 4, "Strategy"));
        collection.addGame(new BoardGame("Azul", 2, 4, "Abstract"));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            printer.viewAllGames();
        } finally {
            System.setOut(original);
        }

        String output = out.toString();
        assertTrue(output.contains("Game: Azul (2-4 players) - Abstract"));
        assertTrue(output.contains("Game: Catan (3-4 players) - Strategy"));
        assertTrue(output.indexOf("Azul") < output.indexOf("Catan")); // sorted order
    }

    @Test
    void testViewEmptyCollection() {
        GameCollection collection = new GameCollection();
        GamePrinter printer = new GamePrinter(collection);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            printer.viewAllGames();
        } finally {
            System.setOut(original);
        }

        String output = out.toString();
        assertTrue(output.contains("No board games in collection."));
    }

}
