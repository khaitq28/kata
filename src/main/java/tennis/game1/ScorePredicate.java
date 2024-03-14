package tennis.game1;

import java.util.function.Predicate;

public class ScorePredicate implements Predicate<Score> {
    @Override
    public boolean test(Score score) {
        return score.isApply();
    }
}
