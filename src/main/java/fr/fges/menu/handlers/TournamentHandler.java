package fr.fges.menu.handlers;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;

import java.util.ArrayList;
import java.util.List;

public class TournamentHandler implements MenuHandler{
    private final GameService gameService;

    public TournamentHandler(GameService gameService) {
        this.gameService = gameService;
    }

    private List<String> populatePlayers(int playerCount) {
        List<String> playerList = new ArrayList<>();
        for(int player = 0; player < playerCount; player++) {
            String playerName = InputHandler.ask("Enter player "+(player+1)+" name");
            playerList.add(playerName);
        }
        return playerList;
    }

    @Override
    public void execute(GameCollection collection) {
        /* Potentiellement séparer dans une fonction jusque... */
        List<BoardGame> jeuxDeuxJoueurs = gameService.filterGamesByPlayerCount(collection, 2);
        if(jeuxDeuxJoueurs.isEmpty()) {MenuView.showMessage("Nooope");}

        MenuView.showMessage("=== Tournament Mode ===\n" +"Available 2-player games");
        for(int i = 0; i < jeuxDeuxJoueurs.size(); i++) {
            MenuView.showMessage((i+1)+". "+jeuxDeuxJoueurs.get(i));
        }
        int indexJeuChoisi = Integer.parseInt(InputHandler.ask("Select game (1-"+jeuxDeuxJoueurs.size()+")"));
        BoardGame jeuChoisi = jeuxDeuxJoueurs.get(indexJeuChoisi-1);
        /* ...cet endroit */

        int playerCount = Integer.parseInt(InputHandler.ask("\nNumber of participants (3-8)"));
        if(playerCount < 3 || playerCount > 8) {MenuView.showMessage("Nooope");}
        List<String> players = populatePlayers(playerCount);

        MenuView.showMessage("\nChoose format:\n"+
        "1. Championship (everyone plays everyone)\n"+
        "2. King of the Hill (winner stays)");
        int modeChoisi = Integer.parseInt(InputHandler.ask("Select format (1-2)"));
        if(modeChoisi == 1){ Championship(jeuChoisi, players);} else { KOTH(jeuChoisi, players); }
    }

    private void Championship(BoardGame jeuChoisi, List<String> players) {
    }

    private void KOTH(BoardGame jeuChoisi, List<String> players) {
    }
}
