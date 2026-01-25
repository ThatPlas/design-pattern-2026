package fr.fges;

//gestion affichage console 
public class MenuView {

    public static void displayMainMenu() {
        System.out.println("""
                === Board Game Collection ===
                1. Add Board Game
                2. Remove Board Game
                3. List All Board Games
                4. Exit
                Please select an option (1-4):
                """);
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }
}
