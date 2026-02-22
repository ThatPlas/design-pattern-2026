package fr.fges.history.actions;

import fr.fges.BoardGame;
import fr.fges.game.GameCollection;

public abstract class LogAction {

    protected final GameCollection collection;
    protected final BoardGame actionContext;

    /**
     * Constructs a LogAction with the specified collection and game context.
     *
     * @param collection the game collection this action operates on
     * @param actionContext the game that is the context of this action
     */
    public LogAction(GameCollection collection, BoardGame actionContext){
        this.collection = collection;
        this.actionContext = actionContext;
    }

    /**
     * Returns the game collection this action operates on.
     *
     * @return the game collection
     */
    public GameCollection getGameCollection(){
        return this.collection;
    }
    /**
     * Returns the game that is the context of this action.
     *
     * @return the action context game
     */
    public BoardGame getActionContext(){
        return this.actionContext;
    }
    /**
     * Reverts the action that was performed.
     * Must be implemented by concrete action classes.
     */
    public abstract void revert();

}
