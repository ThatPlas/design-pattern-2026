package fr.fges;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class MenuControllerTest {

    @Test
    void handleMenu_withInvalidChoice_shouldNotCrash() {
        System.setIn(new ByteArrayInputStream("invalid\n".getBytes()));

        assertDoesNotThrow(() -> MenuController.handleMenu());
    }
}
