package tennis.game2;

public class EqualPoint extends PointStatement{

    public EqualPoint(int p1, int p2) {
        super(p1, p2);
    }

    @Override
    public boolean isMatch() {
        return p1 == p2;
    }

    @Override
    public String getStatement() {
        if (p1 >= 3) return "Deuce";
        return SCORE_LABEL[p1] + "-All";
    }
}
