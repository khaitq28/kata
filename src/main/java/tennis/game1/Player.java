package tennis.game1;

public class Player {

    private final String name;
    private int score;

    public Player(String name) {
        this.name  = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
    public void addScore() {
        this.score ++;
    }

    public boolean isAdvanceOver(Player opp) {
        return getScore()>=4 &&  this.score - opp.getScore() == 1;
    }

    public boolean isWin(Player opp) {
        return getScore()>=4 &&  this.score - opp.getScore() > 1;
    }
}
