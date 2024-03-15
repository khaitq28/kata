package tennis.game2;

import tennis.TennisGame;

import java.util.List;
import java.util.Objects;

public class TennisGame2 implements TennisGame {
    public int point1 = 0;
    public int point2 = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

        return getPoints().stream()
                .filter(PointStatement::isMatch)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Not found this case"))
                .getStatement();
    }

    private List<PointStatement> getPoints() {
        return List.of(
                new AdvantagePoint(point1, point2),
                new EqualPoint(point1, point2),
                new NormalPoint(point1,point2),
                new WinnerPoint(point1, point2));
    }


    public void addPoint1(){
        point1 ++;
    }

    public void addPoint2(){
        point2 ++;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, "player1"))
            addPoint1();
        else
            addPoint2();
    }
}