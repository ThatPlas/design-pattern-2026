package fr.fges.history.actions;

import fr.fges.game.GameCollection;

public abstract class LogAction<T> {

    protected final GameCollection collection;
    protected final T actionContext;

    public LogAction(GameCollection collection, T actionContext){
        this.collection = collection;
        this.actionContext = actionContext;
    }

    public GameCollection getGameCollection(){
        return this.collection;
    }
    public T getActionContext(){
        return this.actionContext;
    }
    public abstract void revert();

}
