package tennis.game1;

public abstract class Score {

    protected static final String []  SCORE = {"Love", "Fifteen", "Thirty", "Forty"};

    protected Player player1;
    protected Player player2;

    public Score(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    abstract public boolean isApply();

    abstract public String statement();
}
