package tennis.game1;


import tennis.TennisGame;

import java.util.Objects;
import java.util.stream.Stream;

public class TennisGame1 implements TennisGame {
    
    private final Player player1;
    private final Player player2;
    private final GameState state;

    public TennisGame1(String player1Name, String player2Name) {
       player1 = new Player(player1Name);
       player2 = new Player(player2Name);
       state = new GameState(player1, player2);
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
        return state.getScore().statement();
    }


}