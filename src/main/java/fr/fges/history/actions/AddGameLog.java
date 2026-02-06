package fr.fges.history.actions;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;

public class AddGameLog extends LogAction<BoardGame> {

    public AddGameLog(GameCollection collection, BoardGame game){
        super(collection, game);
    }

    @Override
    public void revert() {
        this.getGameCollection().removeGame(this.getActionContext());
    }
}
