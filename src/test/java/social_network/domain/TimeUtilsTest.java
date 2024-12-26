package social_network.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {

    @Test
    void getTimeDiff() {

        LocalDateTime now = LocalDateTime.now().minusHours(3);
        assertEquals("3 hours ago", TimeUtils.getTimeDiff(now));

        now = LocalDateTime.now().minusDays(3);
        assertEquals("3 days ago", TimeUtils.getTimeDiff(now));

    }
}