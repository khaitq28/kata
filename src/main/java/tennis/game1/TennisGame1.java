package tennis.game1;


import tennis.TennisGame;

import java.util.List;
import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private final Player player1;
    private final Player player2;
    public TennisGame1(String player1Name, String player2Name) {
       player1 = new Player(player1Name);
       player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).addScore();
    }

    private Player getPlayer(String name) {
        if (Objects.equals(player1.getName(), name)) return player1;
        if (Objects.equals(player2.getName(), name)) return player2;
        throw new RuntimeException(name + " does not exists");
    }
    public String getScore() {
        return allScore().stream()
                .filter(new ScorePredicate())
                .findFirst()
                .get().statement();
    }

    private List<Score> allScore() {
        return List.of(
                new DeuceScore(player1,player2),
                new AdvantageScore(player1, player2),
                new EqualScore(player1, player2),
                new NormalScore(player1, player2),
                new WinScore(player1, player2));
    }
}