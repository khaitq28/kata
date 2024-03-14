package tennis.game1;

public class NormalScore extends Score {
    public NormalScore(Player p1, Player p2) {
        super(p1, p2);
    }

    @Override
    public boolean isApply() {
        return player1.getScore() != player2.getScore() && player1.getScore()<4 && player2.getScore()<4;
    }

    @Override
    public String statement() {
        return getNormalScore(player1) + "-" + getNormalScore(player2);
    }

    private String getNormalScore(Player player) {
        if (player.getScore() <= 3) return SCORE[player.getScore()];
        return "";
    }

}
