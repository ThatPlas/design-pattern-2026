package fr.fges;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        MenuView.displayMainMenu();

        String output = outputStream.toString();
        assertTrue(output.contains("Board Game Collection"));
        assertTrue(output.contains("Add Board Game"));
        assertTrue(output.contains("Exit"));
    }

    @Test
    void showMessage_shouldPrintMessage() {
        MenuView.showMessage("Test message");

        assertTrue(outputStream.toString().contains("Test message"));
    }
}
