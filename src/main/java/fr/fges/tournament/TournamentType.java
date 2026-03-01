package fr.fges.tournament;

import java.util.LinkedList;
import java.util.List;

public interface TournamentType {

    TournamentMatch nextMatch();
    List<TournamentPlayer> getPlayers();
    LinkedList<TournamentPlayer> getLeaderboard();
    int getMatchCount();

}
