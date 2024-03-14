package tennis.game1;

public class AdvantageScore extends Score {
    public AdvantageScore(Player p1, Player p2) {
        super(p1, p2);
    }

    @Override
    public boolean isApply() {
        return  player1.isAdvanceOver(player2) || player2.isAdvanceOver(player1);
    }

    @Override
    public String statement() {
        return player1.isAdvanceOver(player2) ? "Advantage player1" : "Advantage player2";
    }
}
