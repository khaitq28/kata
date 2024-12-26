package social_network.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TimeUtils {

    private static final List<ChronoUnit> UNITS = List.of(ChronoUnit.YEARS,
                                                            ChronoUnit.MONTHS,
                                                            ChronoUnit.DAYS,
                                                            ChronoUnit.HOURS,
                                                            ChronoUnit.MINUTES,
                                                            ChronoUnit.SECONDS);
    public static String getTimeDiff(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        for(ChronoUnit unit : UNITS) {
            long diff = time.until(now, unit);
            if(diff > 0) {
                return message(unit, diff);
            }
        }
        return "just now";
    }

    private static String message(ChronoUnit unit, long diff) {
        String unitStr = unit.toString().toLowerCase();
        if (diff == 1) {
            unitStr = unitStr.substring(0, unitStr.length() - 1);
        }
        return diff + " " + unitStr + " ago";
    }

}
