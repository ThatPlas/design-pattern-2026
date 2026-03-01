package fr.fges.menu.handlers;

import fr.fges.BoardGame;
import fr.fges.InputHandler;
import fr.fges.game.GameCollection;
import fr.fges.game.GameService;
import fr.fges.menu.MenuView;
import fr.fges.tournament.Tournament;
import fr.fges.tournament.TournamentMatch;
import fr.fges.tournament.TournamentPlayer;
import fr.fges.tournament.TournamentService;

import java.util.ArrayList;
import java.util.List;

public class TournamentHandler implements MenuHandler{
    private final GameService gameService;
    private final TournamentService tournamentService;

    public TournamentHandler(GameService gameService, TournamentService tournamentService) {
        this.gameService = gameService;
        this.tournamentService = tournamentService;
    }

    @Override
    public void execute(GameCollection collection) {

        Tournament tournament = this.finalizeCreation(this.promptPlayersNames(this.askPlayerCount()), this.promptGame(collection, gameService));
        this.promptMatchsResults(tournament);
        this.displayLeaderboard(tournament);

    }

    public int askPlayerCount(){
        int playerCount = Integer.parseInt(InputHandler.ask("\nNumber of participants (3-8)"));

        if(playerCount < 3 || playerCount > 8) {

            MenuView.showMessage("Not a valid number of players");
            System.exit(1);

        }

        return playerCount;
    }

    public List<TournamentPlayer> promptPlayersNames(int playerCount) {

        List<TournamentPlayer> playerList = new ArrayList<>();
        for(int player = 0; player < playerCount; player++) {
            String playerName = InputHandler.ask("Enter player "+(player+1)+" name");
            playerList.add(new TournamentPlayer(playerName));
        }
        return playerList;
    }

    public BoardGame promptGame(GameCollection gameCollection, GameService gameService){

        List<BoardGame> twoPlayersGames = gameService.filterGamesByPlayerCount(gameCollection, 2);

        if(twoPlayersGames.isEmpty()) {
            MenuView.showMessage("There's no 2-players games.");
            System.exit(1);
        }

        MenuView.showMessage("=== Tournament Mode ===\n" +"Available 2-player games");
        for(int i = 0; i < twoPlayersGames.size(); i++) {
            MenuView.showMessage((i+1)+". "+twoPlayersGames.get(i));
        }
        int indexChoosedGame = Integer.parseInt(InputHandler.ask("Select game (1-"+twoPlayersGames.size()+")"));
        BoardGame choosedGame = twoPlayersGames.get(indexChoosedGame-1);

        return choosedGame;
    }

    public void promptMatchsResults(Tournament tournament){

        int i = 1;
        TournamentMatch match;
        while((match = tournamentService.launchNextMatch(tournament)) != null){

            MenuView.showMessage("=== Match " + (i++) + "/" + tournament.type().getMatchCount() + " ===");
            MenuView.showMessage(match.getPlayer1().getName() + " vs " + match.getPlayer2().getName());

            int winner = Integer.parseInt(InputHandler.ask("Winner (1=" + match.getPlayer1().getName() + ", 2=" + match.getPlayer2().getName() + "): "));
            tournamentService.endMatch(tournament, match, winner);

        }

    }

    public Tournament finalizeCreation(List<TournamentPlayer> players, BoardGame game){

        MenuView.showMessage("\nChoose format:\n"+
                "1. Championship (everyone plays everyone)\n"+
                "2. King of the Hill (winner stays)");

        int choosedType = Integer.parseInt(InputHandler.ask("Select format (1-2)"));
        if(choosedType == 1){
            return this.tournamentService.createChampionshipTournament(game.title(), players);
        } else {
            return this.tournamentService.createKoTHTournament(game.title(), players);
        }

    }

    public void displayLeaderboard(Tournament tournament){

        MenuView.showMessage("=== Tournament Results ===");
        List<TournamentPlayer> leaderboard = tournament.type().getLeaderboard();
        for(int i = 0; i < tournament.type().getPlayers().size(); i++){

            TournamentPlayer player = leaderboard.get(i);
            MenuView.showMessage(i + ". " + player.getName() + " - " + player.getScore() + " points (" + player.getNbVictory() + " wins)");

        }

    }



}
