package tennis.game2;

public class WinnerPoint extends PointStatement{

    public WinnerPoint(int p1, int p2) {
        super(p1, p2);
    }

    String[] SCORE_LABEL = {"Love", "Fifteen", "Thirty", "Forty"};

    @Override
    public boolean isMatch() {
        return Math.abs(p1 - p2) >=2 && Math.max(p1, p2) >= 4;
    }

    @Override
    public String getStatement() {
        return p2 > p1 ? "Win for player2":"Win for player1";
    }
}
