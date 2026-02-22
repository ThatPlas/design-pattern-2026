package fr.fges.history.actions;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;

public class AddGameLog extends LogAction {

    /**
     * Constructs an AddGameLog for the specified collection and game.
     *
     * @param collection the game collection
     * @param game the game that was added
     */
    public AddGameLog(GameCollection collection, BoardGame game){
        super(collection, game);
    }

    /**
     * Reverts the add game action by removing the game from the collection.
     */
    @Override
    public void revert() {
        this.getGameCollection().removeGame(this.getActionContext());
    }
}
