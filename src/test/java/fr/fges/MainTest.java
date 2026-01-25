package fr.fges;

import fr.fges.Main;
import org.junit.jupiter.api.Test;

import java.io.File;

import static fr.fges.Main.main;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testMain() {
        File file = new File("testmain.json");

        main(file.list());
    }
}
