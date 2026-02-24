package fr.fges.game;

import fr.fges.GameRepository;
import fr.fges.exception.UnsupportedFileExtension;

public class GameRepositoryFactory {

    public static GameRepository create(String storageFile) throws UnsupportedFileExtension {

        return switch(storageFile.toLowerCase().substring(storageFile.lastIndexOf('.'))){
            case ".json" -> new JSONGameRepository(storageFile);
            case ".csv" -> new CSVGameRepository(storageFile);
            default -> throw new UnsupportedFileExtension();
        };

    }

}
