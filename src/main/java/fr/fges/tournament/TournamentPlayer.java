package fr.fges.tournament;

import java.util.Map;

public class TournamentPlayer{

    private String name;
    private int score;
    private int nbVictory;
    private int nbLoose;
    private Map<TournamentMatch, Boolean> matches;

    public TournamentPlayer(String name) {
        this.name = name;
    }

    public void addWin(){
        this.nbVictory++;
        this.addScore(3);
    }

    public void addLose(){
        this.nbLoose++;
        this.addScore(1);
    }

    private void addScore(int score){
        this.score+=score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getNbVictory() {
        return nbVictory;
    }

    public int getNbLoose() {
        return nbLoose;
    }

    public Map<TournamentMatch, Boolean> getMatches() {
        return matches;
    }
}
