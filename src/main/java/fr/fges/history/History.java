package fr.fges.history;

import fr.fges.history.actions.LogAction;

import java.util.ArrayList;
import java.util.List;

public class History {

    private List<LogAction<?>> actions;

    public History(){
        this.actions = new ArrayList<>();
    }

    protected List<LogAction<?>> getActions(){
        return this.actions;
    }

    protected LogAction<?> getLastAction(){
        return this.getActions().getLast();
    }

    protected void addAction(LogAction<?> action){
        this.actions.add(action);
    }

    protected void removeAction(LogAction<?> action){
        this.actions.remove(action);
    }

}
