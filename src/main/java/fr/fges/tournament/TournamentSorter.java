package fr.fges.tournament;

import java.util.Comparator;

public class TournamentSorter implements Comparator<TournamentPlayer> {
    @Override
    public int compare(TournamentPlayer o1, TournamentPlayer o2) {
        int comparePoints = Integer.compare(o2.getScore(), o1.getScore());
        if (comparePoints != 0) {
            return comparePoints;
        }

        int compareWins = Integer.compare(o2.getNbVictory(), o1.getNbVictory());
        if (compareWins != 0) {
            return compareWins;
        }

        return o1.getName().compareTo(o2.getName());
    }
}
