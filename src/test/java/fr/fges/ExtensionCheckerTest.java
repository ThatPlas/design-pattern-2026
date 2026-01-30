package fr.fges;

import fr.fges.exception.UnsupportedFileExtension;
import fr.fges.game.GameRepository;
import org.junit.jupiter.api.Test;

import java.io.File;

import static fr.fges.ExtensionChecker.checkFileExtension;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtensionCheckerTest {

    @Test
    public void supportedExtension() {
        File file = new File("testExtension.json");
        GameRepository gameRepository = new GameRepository();
        assertDoesNotThrow(() -> checkFileExtension(String.valueOf(file), gameRepository));
    }

    @Test
    public void unsupportedExtension() {
        File file = new File("testExtension.xml");
        GameRepository gameRepository = new GameRepository();

        assertThrows(UnsupportedFileExtension.class, () -> checkFileExtension(String.valueOf(file), gameRepository));
    }
}
