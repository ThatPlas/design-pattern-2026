package fr.fges.history.actions;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;

public class RemoveGameLog extends LogAction<BoardGame> {

    public RemoveGameLog(GameCollection collection, BoardGame actionContext) {
        super(collection, actionContext);
    }

    @Override
    public void revert() {
        this.getGameCollection().addGame(this.getActionContext());
    }
}