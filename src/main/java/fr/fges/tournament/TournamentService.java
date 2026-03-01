package fr.fges.tournament;

import java.util.List;

public class TournamentService {

    public Tournament createKoTHTournament(String game, List<TournamentPlayer> players){
        return new Tournament(game, new KoTHTournamentType(players));

    }

    public Tournament createChampionshipTournament(String game, List<TournamentPlayer> players){
        return new Tournament(game, new ChampionshipTournamentType(players));
    }

    public TournamentMatch launchNextMatch(Tournament tournament){
        return tournament.type().nextMatch();
    }

    public boolean endMatch(Tournament tournament, TournamentMatch match, int winnerPlayer){

        if(winnerPlayer != 1 && winnerPlayer != 2){
            return false;
        }

        match.declareWinner(winnerPlayer);

        if(tournament.type() instanceof KoTHTournamentType){
            ((KoTHTournamentType) tournament.type()).recordResult(match.getWinner());
        }

        return true;
    }

}
