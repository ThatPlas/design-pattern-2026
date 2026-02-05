package fr.fges;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import fr.fges.menu.MenuView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void displayMainMenu_shouldPrintMenu() {
        MenuView.displayMainMenu(List.of("Add Board Game", "View Collection", "Exit"));

        String output = outputStream.toString();
        assertTrue(output.contains("Add Board Game"));
        assertTrue(output.contains("View Collection"));
        assertTrue(output.contains("Exit"));
    }

    @Test
    void showMessage_shouldPrintMessage() {
        MenuView.showMessage("Test message");

        assertTrue(outputStream.toString().contains("Test message"));
    }
}
