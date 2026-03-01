package fr.fges.tournament;

import java.util.*;

public class ChampionshipTournamentType implements TournamentType{

    private List<TournamentPlayer> players;
    private Queue<TournamentMatch> matches;

    public ChampionshipTournamentType(List<TournamentPlayer> players){
        this.players = players;
        this.matches = this.generateAllMatches();
    }

    private Queue<TournamentMatch> generateAllMatches() {
        Queue<TournamentMatch> matches = new LinkedList<>();
        List<TournamentPlayer> pool = new ArrayList<>(this.players);

        if (pool.size() % 2 != 0) {
            pool.add(null);
        }

        int n = pool.size();
        int rounds = n - 1;

        for (int r = 0; r < rounds; r++) {
            for (int i = 0; i < n / 2; i++) {
                int homeIdx = (r + i) % (n - 1);
                int awayIdx = (n - 1 - i + r) % (n - 1);

                if (i == 0) awayIdx = n - 1;

                TournamentPlayer p1 = pool.get(homeIdx);
                TournamentPlayer p2 = pool.get(awayIdx);

                if (p1 != null && p2 != null) {
                    matches.add(new TournamentMatch(p1, p2));
                }
            }
        }
        return matches;
    }

    @Override
    public TournamentMatch nextMatch() {
        return matches.poll();
    }

    @Override
    public List<TournamentPlayer> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    @Override
    public LinkedList<TournamentPlayer> getLeaderboard() {
        LinkedList<TournamentPlayer> leaderBoard = new LinkedList<>(players);
        leaderBoard.sort(new TournamentSorter());
        return leaderBoard;
    }

    @Override
    public int getMatchCount(){
        if (this.players.size() < 2) return 0;
        return (this.players.size() * (this.players.size() - 1)) / 2;
    }

}
