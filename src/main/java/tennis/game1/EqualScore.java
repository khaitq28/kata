package tennis.game1;

public class EqualScore extends Score {
    public EqualScore(Player p1, Player p2) {
        super(p1, p2);
    }
    @Override
    public boolean isApply() {
        return this.player1.getScore() == this.player2.getScore() && player1.getScore() <= 2;
    }
    @Override
    public String statement() {
        return SCORE[player1.getScore()] + "-All";
    }

}
