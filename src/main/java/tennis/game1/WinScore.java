package tennis.game1;

public class WinScore extends Score {
    public WinScore(Player p1, Player p2) {
        super(p1, p2);
    }

    @Override
    public boolean isApply() {
        return player1.isWin(player2) || player2.isWin(player1);
    }

    @Override
    public String statement() {
        return  player1.isWin(player2) ? "Win for player1" : "Win for player2";
    }
}
