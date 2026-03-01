package fr.fges.tournament;

public class TournamentMatch {

    private TournamentPlayer player1;
    private TournamentPlayer player2;

    private TournamentPlayer winner;

    public TournamentMatch(TournamentPlayer player1, TournamentPlayer player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public TournamentPlayer getWinner(){
        return this.winner;
    }

    public void declareWinner(int playerNumber){

        if(playerNumber == 1){
            this.winner = this.player1;
            this.player1.addWin();
            this.player2.addLose();
        } else {
            this.winner = this.player2;
            this.player1.addLose();
            this.player2.addWin();
        }
    }

    public TournamentPlayer getPlayer1() {
        return player1;
    }

    public TournamentPlayer getPlayer2() {
        return player2;
    }
}
