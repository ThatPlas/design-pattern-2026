package fr.fges.tournament;

import java.util.*;

public class KoTHTournamentType implements TournamentType{

    private List<TournamentPlayer> players;
    private Deque<TournamentPlayer> waitingQueue;
    private TournamentPlayer currentKing;

    public KoTHTournamentType(List<TournamentPlayer> players){
        this.players = players;
        List<TournamentPlayer> shuffled = new ArrayList<>(players);
        Collections.shuffle(shuffled);
        this.waitingQueue = new ArrayDeque<>(shuffled);

        this.currentKing = waitingQueue.poll();
    }

    public void recordResult(TournamentPlayer winner){
        this.currentKing = winner;
    }

    @Override
    public TournamentMatch nextMatch() {

        if(waitingQueue.isEmpty()) return null;

        TournamentPlayer challenger = waitingQueue.poll();

        return new TournamentMatch(currentKing, challenger);
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
        return this.players.size() - 1;
    }

}
