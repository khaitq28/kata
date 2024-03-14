package tennis.game1;

public class DeuceScore extends Score {
    public DeuceScore(Player p1, Player p2) {
        super(p1, p2);
    }

    @Override
    public boolean isApply() {
        return this.player1.getScore() == this.player2.getScore() && this.player1.getScore() > 2;
    }

    @Override
    public String statement() {
        return "Deuce";
    }
}
