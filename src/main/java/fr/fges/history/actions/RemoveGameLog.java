package fr.fges.history.actions;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;

public class RemoveGameLog extends LogAction {

    /**
     * Constructs an RemoveGameLog for the specified collection and game.
     *
     * @param collection the game collection
     * @param game the game that was added
     */
    public RemoveGameLog(GameCollection collection, BoardGame game) {
        super(collection, game);
    }

    /**
     * Reverts the remove game action by adding the game from the collection.
     */
    @Override
    public void revert() {
        this.getGameCollection().addGame(this.getActionContext());
    }
}