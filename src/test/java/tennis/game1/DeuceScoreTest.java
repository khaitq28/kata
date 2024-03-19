package tennis.game1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DeuceScoreTest {

    @Mock
    private Player player1;
    @Mock
    private Player player2;

    @Test
    public void testIsApply() {
        when(player1.getScore()).thenReturn(3);
        when(player2.getScore()).thenReturn(3);
        DeuceScore deuceScore = new DeuceScore(player1, player2);
        assertTrue(deuceScore.isApply());
    }

    @Test
    public void testNotApply() {
        when(player1.getScore()).thenReturn(3);
        when(player2.getScore()).thenReturn(2);
        DeuceScore deuceScore = new DeuceScore(player1, player2);
        assertFalse(deuceScore.isApply());
    }

    @Test
    public void testStatement() {
        DeuceScore deuceScore = new DeuceScore(new Player("abc"), new Player("def"));
        assertEquals(deuceScore.statement(), "Deuce");
    }

}