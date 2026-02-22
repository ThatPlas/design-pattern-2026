package fr.fges.history;

import fr.fges.game.GameCollection;
import fr.fges.history.actions.LogAction;

public class HistoryService {

    /**
     * Adds a log action to the history.
     *
     * @param history the history to add the action to
     * @param action the log action to add
     */
    public void addLogAction(History history, LogAction action){
        history.addAction(action);
    }

    /**
     * Removes a log action from the history.
     *
     * @param history the history to remove the action from
     * @param action the log action to remove
     */
    public void removeLogAction(History history, LogAction action){
        history.removeAction(action);
    }

    /**
     * Reverts the last action performed on the game collection.
     *
     * @param collection the collection to revert the last action on
     */
    public void revertLastAction(GameCollection collection){
        collection.getHistory().getLastAction().revert();
    }



}
