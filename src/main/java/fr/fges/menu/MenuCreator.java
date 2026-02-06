package fr.fges.menu;

import fr.fges.menu.handlers.MenuHandler;
import fr.fges.menu.options.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuCreator {

    private List<MenuOption> options = new ArrayList<>();

    public MenuCreator(){
        options.add(new AddGameOption());
        options.add(new RemoveGameOption());
        options.add(new ListGameOption());
        options.add(new RecommandGameOption());
        options.add(new ViewSummaryOption());
        options.add(new UndoActionOption());
        options.add(new ExitOption());
    }

    public Map<String, Integer> getAvailableOptions(LocalDate date){

        Map<String, Integer> options = new LinkedHashMap<>();
        for(MenuOption option : this.options){
            if(option.isAvailable(date)){
                options.put(option.title(), this.options.indexOf(option));
            }
        }

        return options;
    }

    public MenuOption getOption(int i){
        return this.options.get(i);
    }

    public void addOption(MenuOption option){
        this.options.add(this.options.size()-2, option);
    }

    public void putOption(MenuOption option, int index){
        this.options.set(index, option);
    }


}
