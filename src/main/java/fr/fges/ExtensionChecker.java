package fr.fges;

public class ExtensionChecker {
    public static void checkFileExtension(String storageFile) {
        // Check file extension
        if (!storageFile.endsWith(".json") && !storageFile.endsWith(".csv")) {
            System.out.println("Error: Storage file must have .json or .csv extension");
            System.exit(1);
        }
    }
}