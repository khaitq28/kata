package tennis.game2;

public abstract class PointStatement {

    protected String[] SCORE_LABEL = {"Love", "Fifteen", "Thirty", "Forty"};


    protected int p1;
    protected int p2;
    public PointStatement(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public abstract boolean isMatch();

    public abstract String getStatement();

}
