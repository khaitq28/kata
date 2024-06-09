package ScoreKeeper;

public class ScoreKeeper {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    private final String DELIMITER = ":";

    public String getScore() {
        return getScoreTeamA() + DELIMITER + getScoreTeamB();
    }

    private String getScoreTeamB() {
        return String.format("%03d", scoreTeamB);
    }

    private String getScoreTeamA() {
        return String.format("%03d", scoreTeamA);
    }
    public void scoreTeamA1() {
        scoreTeamA++;
    }
    public void scoreTeamA2() {
        scoreTeamA += 2;
    }
    public void scoreTeamA3() {
        scoreTeamA += 3;
    }

    public void scoreTeamB1() {
        scoreTeamB++;
    }
    public void scoreTeamB2() {
        scoreTeamB += 2;
    }
    public void scoreTeamB3() {
        scoreTeamB += 3;
    }
}
