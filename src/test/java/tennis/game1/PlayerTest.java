package tennis.game1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    private Player player;

    @Test
    public void testName() {
        player = new Player("abc");
        assertEquals(player.getName(), "abc");
    }

    @Test
    public void testAddScore() {
        player = new Player("abc");
        for (int i = 0; i < 100; i++) {
            player.addScore();
            assertEquals(player.getScore(), i+1);
        }
    }

    @Test
    void isAdvantageOverOther() {
        player = new Player("abc");
        Player other = new Player("def");
        for (int i = 0; i < 4; i++) {
            player.addScore();
        }
        for (int i = 0; i < 3; i++) {
            other.addScore();
        }
        assertTrue(player.isAdvanceOver(other));
    }

    @Test
    void isWin() {
        player = new Player("abc");
        Player other = new Player("def");
        for (int i = 0; i < 4; i++) {
            player.addScore();
        }
        for (int i = 0; i < 2; i++) {
            other.addScore();
        }
        assertTrue(player.isWin(other));
    }
}