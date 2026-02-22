package fr.fges.history;

import fr.fges.history.actions.LogAction;

import java.util.ArrayList;
import java.util.List;

public class History {

    private final List<LogAction> actions;

    /**
     * Constructs a History with an empty list of actions.
     */
    public History(){
        this.actions = new ArrayList<>();
    }

    /**
     * Returns the list of all logged actions.
     *
     * @return list of log actions
     */
    public List<LogAction> getActions(){
        return this.actions;
    }

    /**
     * Returns the most recently added action.
     *
     * @return the last action in the history
     */
    public LogAction getLastAction(){
        return this.getActions().getLast();
    }

    /**
     * Adds an action to the history.
     *
     * @param action the action to add
     */
    protected void addAction(LogAction action){
        this.actions.add(action);
    }

    /**
     * Removes an action from the history.
     *
     * @param action the action to remove
     */
    protected void removeAction(LogAction action){
        this.actions.remove(action);
    }

}
