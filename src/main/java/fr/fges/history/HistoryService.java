package fr.fges.history;

import fr.fges.game.GameCollection;
import fr.fges.history.actions.LogAction;

public class HistoryService {

    public static void addLogAction(History history, LogAction<?> action){
        history.addAction(action);
    }

    public static void removeLogAction(History history, LogAction<?> action){
        history.removeAction(action);
    }

    public static void revertLastAction(GameCollection collection){
        collection.getHistory().getLastAction().revert();
    }



}
