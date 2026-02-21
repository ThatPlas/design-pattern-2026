package fr.fges.history.actions;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;

public abstract class LogAction {

    protected final GameCollection collection;
    protected final BoardGame actionContext;

    public LogAction(GameCollection collection, BoardGame actionContext){
        this.collection = collection;
        this.actionContext = actionContext;
    }

    public GameCollection getGameCollection(){
        return this.collection;
    }
    public BoardGame getActionContext(){
        return this.actionContext;
    }
    public abstract void revert();

}
