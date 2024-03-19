package tennis.game1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class WinScoreTest {

    @Mock
    private Player player1;

    @Mock
    private Player player2;
    @Test
    public void isApply() {
        when(player1.isWin(player2)).thenReturn(true);
        WinScore winScore = new WinScore(player1, player2);
        assertTrue(winScore.isApply());
    }

    @Test
    public void testIsApply2() {
        when(player2.isWin(player1)).thenReturn(true);
        WinScore winScore = new WinScore(player1, player2);
        assertTrue(winScore.isApply());
    }

    @Test
    public void statement() {
        when(player1.isWin(player2)).thenReturn(true);
        WinScore winScore = new WinScore(player1, player2);
        assertEquals(winScore.statement(), "Win for player1");
    }


    @Test
    public void statement2() {
        when(player2.isWin(player1)).thenReturn(true);
        WinScore winScore = new WinScore(player1, player2);
        assertEquals(winScore.statement(), "Win for player2");
    }
}