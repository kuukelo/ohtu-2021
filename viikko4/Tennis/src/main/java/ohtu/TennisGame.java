package ohtu;

public class TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;
    private String gameScore;
    private String[] scores;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.gameScore = "Love-All";
        this.scores = new String[5];
        formatScores();        
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            scorePlayer1 += 1;
        } else {
            scorePlayer2 += 1;
        }
        changeScore();
    }

    public String getScore() {
        return gameScore;
    }

    private void changeScore() {
        if (scorePlayer1 == scorePlayer2) {
            scoreIsEven();
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            playerHasAdvantege();
        } else {
            gameScore = scores[scorePlayer1] + "-" + scores[scorePlayer2];
        }
    }

    private void scoreIsEven() {
        if (scorePlayer1 >= 4) {
            gameScore = scores[4];
        } else {
            gameScore = scores[scorePlayer1] + "-All";
        }
    }

    private void playerHasAdvantege() {
        int difference = scorePlayer1-scorePlayer2;
        if (difference==1) gameScore ="Advantage player1";
        else if (difference ==-1) gameScore ="Advantage player2";
        else if (difference>=2) gameScore = "Win for player1";
        else gameScore ="Win for player2";
    }

    private void formatScores() {
        scores[0] = "Love";
        scores[1] = "Fifteen";
        scores[2] = "Thirty";
        scores[3] = "Forty";
        scores[4] = "Deuce";
    }
    
}