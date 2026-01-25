package fr.fges;

/**
 * Validates storage file extensions.
 */
public class ExtensionChecker {
    /**
     * Ensures the storage file has a supported extension.
     *
     * @param storageFile storage file path to validate
     */
    public static void checkFileExtension(String storageFile) {
        if (!storageFile.endsWith(".json") && !storageFile.endsWith(".csv")) {
            System.out.println("Error: Storage file must have .json or .csv extension");
            System.exit(1);
        }
    }
}
