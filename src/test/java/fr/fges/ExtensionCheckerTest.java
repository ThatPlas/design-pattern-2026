package fr.fges;

import org.junit.jupiter.api.Test;

import java.io.File;

import static fr.fges.ExtensionChecker.checkFileExtension;

public class ExtensionCheckerTest {
    @Test
    public void testExtension() {
        File file = new File("testExtension.json");

        checkFileExtension(String.valueOf(file));
    }
}
