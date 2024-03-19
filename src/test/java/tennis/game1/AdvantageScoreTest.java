package tennis.game1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdvantageScoreTest {

    private final Player p1 = new Player("a");
    private final Player p2 = new Player("b");
    private final AdvantageScore score = new AdvantageScore(p1, p2);

    @Test
    public void isApply() {
        p1.addScore();p1.addScore();p1.addScore();p1.addScore();
        p2.addScore();p2.addScore();p2.addScore();
        assertTrue(score.isApply());
    }

    @Test
    public void isNotApply1(){
        p1.addScore();p1.addScore();p1.addScore();
        assertFalse(score.isApply());
    }
    @Test
    public void isNotApply2(){
        assertFalse(score.isApply());
    }

    @Test
    public void isNotApply3(){
        p1.addScore();p1.addScore();p1.addScore();
        p2.addScore();p2.addScore();p2.addScore();
        p1.addScore();p1.addScore();p1.addScore();
        assertFalse(score.isApply());
    }

    @Test
    public void statementAdvantageForPlayer1() {
        p1.addScore();p1.addScore();p1.addScore();p1.addScore();
        p2.addScore();p2.addScore();p2.addScore();
        assertEquals("Advantage player1", score.statement());
    }

    @Test
    public void statementAdvantageForPlayer2() {
        p1.addScore();p1.addScore();p1.addScore();
        p2.addScore();p2.addScore();p2.addScore();p2.addScore();
        assertEquals("Advantage player2", score.statement());
    }
}