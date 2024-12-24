package leapyear;

/**
 * @author Quang-Khai TRAN
 * @date 24/12/2024
 *
 * As a user, I want to know if a year is a leap year,
 * So that I can plan for an extra day on February 29th during those years.
 * Acceptance Criteria:
 *
 * All years divisible by 400 ARE leap years (so, for example, 2000 was indeed a leap year),
 * All years divisible by 100 but not by 400 are NOT leap years (so, for example, 1700, 1800, and 1900 were NOT leap years, NOR will 2100 be a leap year),
 * All years divisible by 4 but not by 100 ARE leap years (e.g., 2008, 2012, 2016)
 * All years not divisible by 4 are NOT leap years (e.g. 2017, 2018, 2019)
 *
 */

public class LeapYearValidator {

    boolean isLeapYear(int n) {
        if (n < 0 || !isDividedBy(n,4))
            return false;
        if (isDividedBy(n,400))
            return true;
        return isDividedBy(n,4) && !isDividedBy(n,100);
    }

    private boolean isDividedBy(int n, int k) {
        if (k == 0) throw new IllegalArgumentException("zero not acceptable");
        return n % k == 0;
    }
    private boolean isDivideBy400(int n) {
        return n % 400 == 0;
    }
    private boolean isDividedBy100(int n) {
        return n % 100 == 0;
    }
    private boolean isDividedBy4(int n) {
        return n % 4 == 0;
    }
}
