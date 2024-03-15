package tennis.game2;

public class NormalPoint extends PointStatement{

    public NormalPoint(int p1, int p2) {
        super(p1, p2);
    }

    @Override
    public boolean isMatch() {
        return p1 != p2 && Math.max(p1,p2) < 4;
    }

    @Override
    public String getStatement() {
        return SCORE_LABEL[p1] + "-" + SCORE_LABEL[p2];
    }
}
