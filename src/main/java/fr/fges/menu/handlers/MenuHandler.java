package fr.fges.menu.handlers;

import fr.fges.game.GameCollection;

public interface MenuHandler {

    /**
     * Executes the menu handler action on the given game collection.
     *
     * @param collection the game collection to operate on
     */
    void execute(GameCollection collection  );

}
