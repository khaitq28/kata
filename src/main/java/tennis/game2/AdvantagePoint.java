package tennis.game2;

public class AdvantagePoint extends PointStatement{

    public AdvantagePoint(int p1, int p2) {
        super(p1, p2);
    }

    @Override
    public boolean isMatch() {
        return Math.abs(p1 - p2) >=1 && Math.min(p1, p2) >= 3;
    }

    @Override
    public String getStatement() {
        return p2 > p1 ? "Advantage player2": "Advantage player1";
    }
}
