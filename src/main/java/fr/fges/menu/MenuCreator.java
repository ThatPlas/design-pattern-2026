package fr.fges.menu;

import fr.fges.game.GameService;
import fr.fges.menu.options.*;
import fr.fges.tournament.TournamentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuCreator {

    private final List<MenuOption> options = new ArrayList<>();

    private final GameService gameService;
    private final TournamentService tournamentService;

    /**
     * Constructs a MenuCreator with the specified game service and default options.
     *
     * @param gameService the service for handling game operations
     */
    public MenuCreator(GameService gameService, TournamentService tournamentService){

        this.gameService = gameService;
        this.tournamentService = tournamentService;


        options.add(new AddGameOption(this.gameService));
        options.add(new RemoveGameOption(this.gameService));
        options.add(new ListGameOption());
        options.add(new FilterByPlayerCountOption(this.gameService));
        options.add(new RecommandGameOption(this.gameService));
        options.add(new ViewSummaryOption());
        options.add(new UndoActionOption(this.gameService));
        options.add(new TournamentOption(this.gameService, tournamentService));
        options.add(new ExitOption(this.gameService));
    }

    /**
     * Returns a map of available menu options for the given date.
     *
     * @param date the date to check option availability for
     * @return map of option titles to their indices
     */
    public Map<String, Integer> getAvailableOptions(LocalDate date){

        Map<String, Integer> options = new LinkedHashMap<>();
        for(MenuOption option : this.options){
            if(option.isAvailable(date)){
                options.put(option.title(), this.options.indexOf(option));
            }
        }

        return options;
    }

    /**
     * Returns the menu option at the specified index.
     *
     * @param i the index of the option to retrieve
     * @return the MenuOption at the given index
     */
    public MenuOption getOption(int i){
        return this.options.get(i);
    }

    /**
     * Adds a new menu option before the last two options (Exit and Undo).
     *
     * @param option the menu option to add
     */
    public void addOption(MenuOption option){
        this.options.add(this.options.size()-2, option);
    }

    /**
     * Replaces the menu option at the specified index.
     *
     * @param option the new menu option to place
     * @param index the index where to place the option
     */
    public void putOption(MenuOption option, int index){
        this.options.set(index, option);
    }


}
