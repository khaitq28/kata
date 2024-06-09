package ScoreKeeper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreKeeperTest {

    private ScoreKeeper scoreKeeper;

    @BeforeEach
    void setUp() {
        scoreKeeper = new ScoreKeeper();
    }
    @Test
    void testGetScore() {
        assertEquals("000:000", scoreKeeper.getScore());
    }

    @Test
    void testGetScoreTeamA1() {
        scoreKeeper.scoreTeamA1();
        assertEquals("001:000", scoreKeeper.getScore());
    }

    @Test
    void testGetScoreTeamA2() {
        scoreKeeper.scoreTeamA2();
        assertEquals("002:000", scoreKeeper.getScore());
    }

    @Test
    void testGetScoreTeamA3() {
        scoreKeeper.scoreTeamA3();
        assertEquals("003:000", scoreKeeper.getScore());
    }

    @Test
    void testGetScoreTeamB1() {
        scoreKeeper.scoreTeamB1();
        assertEquals("000:001", scoreKeeper.getScore());
    }

    @Test
    void testGetScoreTeamB2() {
        scoreKeeper.scoreTeamB2();
        assertEquals("000:002", scoreKeeper.getScore());
    }

    @Test
    void testGetScoreTeamB3() {
        scoreKeeper.scoreTeamB3();
        assertEquals("000:003", scoreKeeper.getScore());
    }

    @Test
    void testGetScoreTeamA1TeamB1() {
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB3();
        assertEquals("003:004", scoreKeeper.getScore());
    }
}