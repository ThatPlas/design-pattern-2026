package fr.fges;

import fr.fges.game.GameCollection;
import fr.fges.game.GameRepository;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java -jar boardgamecollection.jar <storage-file>");
            System.out.println("Storage file must be .json or .csv");
            System.exit(1);
        }

        String storageFile = args[0];

        ExtensionChecker.checkFileExtension(storageFile);

        GameRepository repository = new GameRepository();
        GameCollection collection = new GameCollection();

        collection.addGames(
                repository.loadFromFile(storageFile)
        );

        System.out.println("Using storage file: " + storageFile);

        while (true) {
            MenuController.handleMenu(collection);
        }
    }
}




// package fr.fges;

// import fr.fges.game.GameRepository;
// import fr.fges.ExtensionChecker;
// import fr.fges.Menu;

// import java.util.List;

// public class Main {
//     public static void main(String[] args) {
//         if (args.length < 1) {
//             System.out.println("Usage: java -jar boardgamecollection.jar <storage-file>");
//             System.out.println("Storage file must be .json or .csv");
//             System.exit(1);
//         }

//         String storageFile = args[0];

//         ExtensionChecker.checkFileExtension(storageFile);

//         GameRepository.loadFromFile(storageFile);

//         System.out.println("Using storage file: " + storageFile);

//         while (true) {
//             Menu.handleMenu();
//         }
//     }
// }


