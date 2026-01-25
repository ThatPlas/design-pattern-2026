package fr.fges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    void ask_shouldReturnUserInput() {
        String simulatedInput = "Catan\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String result = InputHandler.ask("Title");

        assertEquals("Catan", result);
    }
}
