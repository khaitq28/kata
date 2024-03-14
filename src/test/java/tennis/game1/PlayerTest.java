package tennis.game1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    private Player player;

    @Test
    public void testName() {
        player = new Player("abc");
        assertEquals(player.getName(), "abc");
    }

    @Test
    public void testScore() {
        player = new Player("abc");
        player.addScore();
        player.addScore();
        assertEquals(player.getScore(), 2);
    }

}