package fr.fges;

import fr.fges.exception.UnsupportedFileExtension;
import fr.fges.game.GameRepository;

/**
 * Validates storage file extensions.
 */
public class ExtensionChecker {
    /**
     * Ensures the storage file has a supported extension.
     *
     * @param storageFile storage file path to validate
     */
    public static void checkFileExtension(String storageFile, GameRepository repository) throws UnsupportedFileExtension {

        String extension = storageFile.toLowerCase().substring(storageFile.lastIndexOf('.'));

        if(!repository.isSupportedExtension(extension)){
            throw new UnsupportedFileExtension(extension + " is not supported.");
        }

    }
}
