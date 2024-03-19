package tennis.game1;

import java.util.List;
import java.util.stream.Stream;

public class GameState {

    private final Player player1;
    private final Player player2;

    public GameState(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Score getScore() {

        return Stream.of(
                        new DeuceScore(player1,player2),
                        new AdvantageScore(player1, player2),
                        new EqualScore(player1, player2),
                        new NormalScore(player1, player2),
                        new WinScore(player1, player2))

                .filter(new ScorePredicate())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found type of score"));
    }
}
